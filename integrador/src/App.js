import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";
import Layout from "./components/layout/Layout";
import Home from "./pages/home/Home";
import Login from "./pages/login/Login";

function App() {
  const [isLogged, setIsLogged] = useState(false);
  return (
    <BrowserRouter>
      <Layout isLogged={isLogged} setIsLogged={setIsLogged}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login argument="login" setIsLogged={setIsLogged}/>} />
          <Route path="/register" element={<Login argument="register" setIsLogged={setIsLogged} />} />
        </Routes>
      </Layout>
    </BrowserRouter>
  );
}

export default App;
