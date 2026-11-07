import { useEffect } from 'react';
import type { ReactNode } from 'react';

export function Modal({
  title,
  children,
  actions,
  onClose,
  scrollable = false,
}: {
  title: string;
  children: ReactNode;
  actions: ReactNode;
  onClose: () => void;
  scrollable?: boolean;
}) {
  useEffect(() => {
    const previousOverflow = document.body.style.overflow;
    document.body.style.overflow = 'hidden';

    return () => {
      document.body.style.overflow = previousOverflow;
    };
  }, []);

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-slate-950/80 p-4">
      <div className={`w-full max-w-lg rounded-2xl border border-white/10 bg-slate-900 p-6 shadow-2xl${scrollable ? ' flex max-h-[90vh] flex-col' : ''}`}>
        <div className="flex items-start justify-between gap-4">
          <h2 className="text-lg font-semibold text-white">{title}</h2>
          <button type="button" onClick={onClose} className="text-slate-400 transition hover:text-white">
            ×
          </button>
        </div>
        <div className={`mt-4${scrollable ? ' min-h-0 overflow-y-auto overscroll-contain' : ''}`}>{children}</div>
        <div className="mt-6 flex justify-end gap-3">{actions}</div>
      </div>
    </div>
  );
}
