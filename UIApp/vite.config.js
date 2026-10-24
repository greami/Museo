import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
const apiProxyTarget = 'http://localhost:8080';
// Browser navigations (e.g. page refresh) request HTML: let the SPA handle them instead of the API.
const apiProxy = {
    target: apiProxyTarget,
    bypass: (req) => req.headers.accept?.includes('text/html') ? '/index.html' : undefined,
};
export default defineConfig({
    plugins: [react()],
    server: {
        host: '0.0.0.0',
        port: 5173,
        proxy: {
            '/auth': apiProxy,
            '/utenti': apiProxy,
            '/ruoli': apiProxy,
            '/utente-ruoli': apiProxy,
            '/eventi': apiProxy,
            '/opere': apiProxy,
            '/evento-opera': apiProxy,
            '/associazioni': apiProxy,
            '/prenotazioni': apiProxy,
            '/feedback-eventi': apiProxy,
            '/feedback-opere': apiProxy,
        },
    },
});
