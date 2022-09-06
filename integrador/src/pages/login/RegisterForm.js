import React, {useState } from "react";
import { useNavigate } from "react-router-dom";
import { FormDiv2, UserForm, MainButton, SecondButton } from "./LoginStyles";

const RegisterForm = ({ handleView }) => {
  const [firstName, setFirstName] = useState(null);
  const [lastName, setLastName] = useState(null);
  const [email, setEmail] = useState(null);
  const [password,setPassword] = useState(null);
  const [confirmPassword,setConfirmPassword] = useState(null);
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(firstName, lastName, email, password, confirmPassword)
  }
  const handleInputChange = (e) => {
    const {id , value} = e.target;
    if(id === "firstName"){
        setFirstName(value);
    }
    if(id === "lastName"){
        setLastName(value);
    }
    if(id === "email"){
        setEmail(value);
    }
    if(id === "password"){
        setPassword(value);
    }
    if(id === "confirmPassword"){
        setConfirmPassword(value);
    }
  }
  return (
    <FormDiv2>
      <h2>Crea tu cuenta</h2>
      <UserForm onSubmit={handleSubmit}>
          <label>
            Nombre:
            <input required type="text" value={firstName} onChange = {(e) => handleInputChange(e)} />
          </label>
          <label>
            Apellido:
            <input required type="text" value={lastName} onChange = {(e) => handleInputChange(e)}/>
          </label>
        <label>
          Email:
          <input required type="email" value={email} onChange = {(e) => handleInputChange(e)}/>
        </label>
        <label>
          Contraeña:
          <input required type="password" value={password} onChange = {(e) => handleInputChange(e)}/>
        </label>
        <label>
          Confirmar contraseña:
          <input required type="password" value={confirmPassword} onChange = {(e) => handleInputChange(e)}/>
        </label>
        <MainButton type="submit">Crear cuenta</MainButton>
      </UserForm>
      <p>Ya tienes una cuenta? <SecondButton onClick={() => handleView("login")}>Inicia Sesion</SecondButton> </p>
    </FormDiv2>
  );
}

export default RegisterForm;