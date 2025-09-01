/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        primary: '#2563eb', // blue-600
        accent: '#10b981',  // emerald-500
      },
    },
  },
  plugins: [require('@tailwindcss/forms')],
}


