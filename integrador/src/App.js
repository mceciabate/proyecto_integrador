import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";
import Layout from "./components/layout/Layout";
import Home from "./pages/home/Home";
import Login from "./pages/login/Login";
import ProductPage from "./pages/product/ProductPage";
import ScrollToTop from "./components/ScrollToTop";
import Reserve from "./pages/reserve/Reserve";
import ReserveSuccess from './pages/reserve/ReserveSuccess'
import AdminProduct from "./pages/admin/AdminProduct";
import React from "react";

function App() {
  const [isLogged, setIsLogged] = useState(false);
  return (
    <BrowserRouter>
      <ScrollToTop/>
      <Layout isLogged={isLogged} setIsLogged={setIsLogged}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login argument="login" setIsLogged={setIsLogged}/>} />
          <Route path="/register" element={<Login argument="register" setIsLogged={setIsLogged} />} />
          <Route path="/product/:id" element={<ProductPage isLogged={isLogged} />} />
          <Route path="/product/:id/reserve" element={<Reserve />} />
          <Route path="/product/:id/reserve/success" element={<ReserveSuccess/>} />
          <Route path="/administracion" element={<AdminProduct />} />
        </Routes>
      </Layout>
    </BrowserRouter>
  );
}

export default App;
