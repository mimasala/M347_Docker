import React from 'react'
import ReactDOM from 'react-dom/client'
import Root from "./routes/root";
import ErrorPage from "./error-page";
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";
import Home from "./Home";
import App from './App'
import './App.css'
import CssBaseline from '@mui/material/CssBaseline';
import { ThemeProvider } from '@emotion/react';
import { darkTheme } from './themes/dark';

const router = createBrowserRouter([
    {
        path: "/",
        element: <Root />,
        errorElement: <ErrorPage />,
    },
    {
        path: "home",
        element: <Home />,
    },
    {
        path: "app",
        element: <App />,
    },
]);

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <RouterProvider router={router} />
    <CssBaseline/>
  </React.StrictMode>,
)
