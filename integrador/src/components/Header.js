import React from "react";
import { HeaderC, SectionC, HeaderButton } from "../styles/HeaderStyles";
import logo from "../assets/logo.png";
import { Link } from "react-router-dom";

const Header = ({ isLogged, setIsLogged }) => {
  console.log(isLogged);
  return (
    <HeaderC>
      <SectionC>
        <Link to="/">
          <img src={logo} alt="logo" />
        </Link>
      </SectionC>
      {isLogged ? (
        <SectionC>
          <h3>Hola Simon</h3>
          <span>SL</span>
          <HeaderButton onClick={()=> setIsLogged(false)}>Log out</HeaderButton>
        </SectionC>
      ) : (
        <SectionC>
          <Link to="/login">
            <HeaderButton>Crear cuenta</HeaderButton>
          </Link>
          <Link to="/register">
            <HeaderButton >Iniciar Sesion</HeaderButton>
          </Link>
        </SectionC>
      )}
    </HeaderC>
  );
};

export default Header;
