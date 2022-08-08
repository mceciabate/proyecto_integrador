import React from "react";
import { useNavigate } from "react-router-dom";

const LoginForm = ({ handleView, setIsLogged }) => {
  const User = {
    email: "simon@gmail.com",
    password: "simon123"
  }
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    if (
      e.target.email.value === User.email &&
      e.target.password.value === User.password
    ) {
      setIsLogged(true);
      navigate("/");
    } else {
      alert("Invalid credentials");
    }
  }
  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Email:
          <input required type="email" placeholder="e-mail" name="email"/>
        </label>
        <label>
          Password:
          <input required type="password" minLength={6} placeholder="password" name="password" />
        </label>
        <button type="submit">Login</button>
      </form>
      <button onClick={() => handleView("register")}>Register</button>
    </div>
  );
}

export default LoginForm;