import React, { useState, useEffect } from "react";
import LoginForm from "./LoginForm";
import RegisterForm from "./RegisterForm";
import { useNavigate } from "react-router-dom";


const Login = ({argument, setIsLogged}) => {
  const navigate = useNavigate();
  const [view, setView] = useState();
  useEffect(() => {
    setView(argument)
    }, [argument])
  const handleView = (view) => {
    setView(view);
  }
  return (
    <div>
      <button onClick={()=> navigate('/')} >X</button>
      {view === "login" ? (
        <LoginForm handleView={handleView} setIsLogged={setIsLogged}  />
      ) : view === "register" ? (
        <RegisterForm handleView={handleView} />
      ) : null}
    </div>
  );

}

export default Login;