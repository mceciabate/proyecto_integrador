import React from "react";
import { useState } from "react";
import { FormDiv, UserForm2, MainButton, SecondButton } from "./LoginStyles";
import { LocalStorageHelper} from 'local-storage-helper'

const LoginForm = ({ handleView, setIsLogged }) => {
  const [email, setEmail] = useState("");
  const [contrasenia, setContrasenia] = useState("");
  LocalStorageHelper.setAppPrefix('Token');
  const handleSubmit = async (e) => {
    e.preventDefault();
    const loginValues = {
      email: email,
      contrasenia: contrasenia
    }
    console.log(JSON.stringify(loginValues))
    await fetch("http://18.223.117.95:8080/auth/token", {
      method: "POST",
      headers: { "Content-Type": "application/json; charset=utf-8" },
      body: JSON.stringify(loginValues),
    })
      .then((response)=> {
        if(response.status === 200) {
          alert("Logged in")
          console.log(response.body)
        }
      })
      .then((respuesta) => {
        console.log(respuesta)
      })
  };
  return (
    <FormDiv>
      <h2>Iniciar Sesion</h2>
      <UserForm2 onSubmit={handleSubmit}>
        <label>
          Email:
          <input
            required
            type="text"
            placeholder="e-mail"
            name="email"
            onChange={(event) => setEmail(event.target.value)}
            value={email}
          />
        </label>
        <label>
          Contraeña:
          <input
            required
            type="text"
            minLength={4}
            placeholder="password"
            name="password"
            onChange={(event) => setContrasenia(event.target.value)}
            value={contrasenia}
          />
        </label>
        <MainButton type="submit">Ingresar</MainButton>
      </UserForm2>
      <p>
        ¿Aún no tienes cuenta?
        <SecondButton onClick={() => handleView("register")}>
          Registrate
        </SecondButton>{" "}
      </p>
    </FormDiv>
  );
};

export default LoginForm;
