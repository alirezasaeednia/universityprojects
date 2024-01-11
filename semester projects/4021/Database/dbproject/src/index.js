import React from "react";
import ReactDOM  from "react-dom";
import App from './App';
import Sign from './pages/sign';
import Result from "./pages/searchresult";
import Up from "./pages/signup";
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom"; 
  
const router = createBrowserRouter([
    {
      path: "/",
      element: <App/>
    },
    {
        path: "sign",
        element: <Sign/>
      },   {
        path: "searchresult",
        element: <Result/>
  },
  {
    path: "signup",
    element: <Up/>
  },
]);
  
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <RouterProvider router={router} />
);