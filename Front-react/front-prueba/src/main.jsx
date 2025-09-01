import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';

import App from './App'; // ✅ Este es suficiente

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>
);


