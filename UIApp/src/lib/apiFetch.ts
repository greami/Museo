import { appConfig } from '../config/appConfig';
import { clearSession } from './auth';

export class ApiError extends Error {
  status: number;
  body: unknown;

  constructor(status: number, message: string, body: unknown) {
    super(message);
    this.status = status;
    this.body = body;
  }
}

function buildUrl(path: string) {
  const baseUrl = appConfig.apiBaseUrl;
  if (!baseUrl || baseUrl.startsWith('/')) {
    return path;
  }
  return new URL(path, baseUrl).toString();
}

function safeParseBody(bodyText: string) {
  try {
    return JSON.parse(bodyText);
  } catch {
    return bodyText;
  }
}

function extractMessage(body: unknown, fallback: string) {
  if (typeof body === 'string' && body.trim()) {
    return body;
  }

  if (body && typeof body === 'object') {
    const candidate = body as { message?: unknown; details?: unknown; error?: unknown };
    const message = candidate.message ?? candidate.details ?? candidate.error;
    if (typeof message === 'string' && message.trim()) {
      return message;
    }
  }

  return fallback;
}

const unauthorizedListeners = new Set<() => void>();

export function onUnauthorized(listener: () => void) {
  unauthorizedListeners.add(listener);
  return () => {
    unauthorizedListeners.delete(listener);
  };
}

export async function apiFetch<T>(path: string, init: RequestInit = {}): Promise<T> {
  const headers = new Headers(init.headers);

  if (!headers.has('Accept')) {
    headers.set('Accept', 'application/json');
  }
  if (init.body && !headers.has('Content-Type') && !(init.body instanceof FormData)) {
    headers.set('Content-Type', 'application/json');
  }

  const response = await fetch(buildUrl(path), {
    ...init,
    headers,
    credentials: 'include',
  });

  const text = await response.text();
  const body = text ? safeParseBody(text) : null;

  if (!response.ok) {
    if (response.status === 401) {
      clearSession();
      unauthorizedListeners.forEach((listener) => listener());
    }
    throw new ApiError(response.status, extractMessage(body, response.statusText || 'Request failed'), body);
  }

  if (response.status === 204) {
    return undefined as T;
  }

  return body as T;
}
