import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { FormDiv, UserForm2, MainButton, SecondButton } from "./LoginStyles";
import { useNavigate } from "react-router-dom";

const LoginForm = ({ handleView, setIsLogged }) => {
  const [email, setEmail] = useState("");
  const [contrasenia, setContrasenia] = useState("");
  const [token, setToken] = useState();
  const [user, setUser] = useState();
  const navigate = useNavigate();
  useEffect(()=>{
    if(token) {
      window.localStorage.setItem('Token', token)
      window.localStorage.setItem('User', user)
      setIsLogged(true);
      navigate('/')
    } else {
      console.log('a')
    }
  },[token, setIsLogged, user, navigate])

  const handleSubmit =  (e) => {
    e.preventDefault();
    const loginValues = {
      email: email,
      contrasenia: contrasenia
    }
    console.log(JSON.stringify(loginValues))
    fetch("http://18.223.117.95:8080/auth/token", {
      method: "POST",
      headers: { "Content-Type": "application/json; charset=utf-8" },
      body: JSON.stringify(loginValues),
    })
      .then((response)=> {
        if(response.status === 200) {
          const json = response.json().then((resp)=>{
            console.log(resp.respuesta)
            setToken(resp.respuesta.token)
            setUser(resp.respuesta.username)
          });
          return json;
        } else {
          alert("Lamentablemente no ha podido iniciar sesión. Por favor intente más tarde")
        }
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
            type="password"
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
