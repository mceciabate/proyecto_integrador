import React from "react";
import { useNavigate } from "react-router-dom";
import { FormDiv2, UserForm, MainButton, SecondButton } from "./LoginStyles";

const RegisterForm = ({ handleView }) => {
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    navigate("/");
  }
  return (
    <FormDiv2>
      <h2>Crea tu cuenta</h2>
      <UserForm onSubmit={handleSubmit}>
        <label>
          Nombre:
          <input required type="text" />
        </label>
        <label>
          Apellido:
          <input required type="text" />
        </label>
        <label>
          Email:
          <input required type="email" />
        </label>
        <label>
          Contraeña:
          <input required type="password" />
        </label>
        <label>
          Confirmar contraeña:
          <input required type="password" />
        </label>
        <MainButton type="submit">Crear cuenta</MainButton>
      </UserForm>
      <p>Ya tienes una cuenta?       <SecondButton onClick={() => handleView("login")}>Inicia Sesion</SecondButton> </p>
    </FormDiv2>
  );
}

export default RegisterForm;