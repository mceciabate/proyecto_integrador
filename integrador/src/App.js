import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";
import Layout from "./components/layout/Layout";
import Home from "./pages/home/Home";
import Login from "./pages/login/Login";
import ProductPage from "./pages/product/ProductPage";
import ScrollToTop from "./components/ScrollToTop";
import Reserve from "./pages/reserve/Reserve";
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
          <Route path="/product/:id" element={<ProductPage />} />
          <Route path="/product/:id/reserve" element={<Reserve />} />
        </Routes>
      </Layout>
    </BrowserRouter>
  );
}

export default App;
