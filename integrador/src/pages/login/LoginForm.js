import React from "react";
import { useNavigate } from "react-router-dom";
import { FormDiv, UserForm, MainButton, SecondButton } from "./LoginStyles";

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
    <FormDiv>
      <h2>Login</h2>
      <UserForm onSubmit={handleSubmit}>
        <label>
          Email:
          <input required type="email" placeholder="e-mail" name="email"/>
        </label>
        <label>
          Password:
          <input required type="password" minLength={6} placeholder="password" name="password" />
        </label>
        <MainButton type="submit">Login</MainButton>
      </UserForm>
      <p>Dont have an account? <SecondButton onClick={() => handleView("register")}>Register</SecondButton> </p>
    </FormDiv>
  );
}

export default LoginForm;