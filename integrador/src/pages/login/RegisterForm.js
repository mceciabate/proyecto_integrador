import React from "react";
import { useNavigate } from "react-router-dom";

const RegisterForm = ({ handleView }) => {
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    navigate("/");
  }
  return (
    <div>
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
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
        <button type="submit">Register</button>
      </form>
      <button onClick={() => handleView("login")}>Login</button>
    </div>
  );
}

export default RegisterForm;