import React from "react";
import { useNavigate } from "react-router-dom";
import { FormDiv, UserForm, MainButton, SecondButton } from "./LoginStyles";

const RegisterForm = ({ handleView }) => {
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    navigate("/");
  }
  return (
    <FormDiv>
      <h2>Register</h2>
      <UserForm onSubmit={handleSubmit}>
        <label>
          Name:
          <input required type="text" />
        </label>
        <label>
          Lastname:
          <input required type="text" />
        </label>
        <label>
          Email:
          <input required type="email" />
        </label>
        <label>
          Password:
          <input required type="password" />
        </label>
        <label>
          Confirm Password:
          <input required type="password" />
        </label>
        <MainButton type="submit">Register</MainButton>
      </UserForm>
      <p>Already have an account?       <SecondButton onClick={() => handleView("login")}>Login</SecondButton> </p>
    </FormDiv>
  );
}

export default RegisterForm;