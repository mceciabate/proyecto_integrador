import React from "react";
import { HeaderC, SectionC, HeaderButton, Logo } from "../styles/HeaderDStyles";
import { Link } from "react-router-dom";

const Header = ({ isLogged, setIsLogged }) => {
  const handleLoggin = () => {
    if(isLogged) {
      return (
        <SectionC>
          <h3>{`Hola ${window.localStorage.getItem("Username")} ${window.localStorage.getItem("Lastname")}`}</h3>
          <span>{`${window.localStorage.getItem("Username").charAt(0).toUpperCase()}${window.localStorage.getItem("Lastname").charAt(0).toUpperCase()}`}</span>
          <HeaderButton
            onClick={() => {
              setIsLogged(false);
              window.localStorage.removeItem('Token');
            }}
          >
            Log out
          </HeaderButton>
        </SectionC>
      );
    } else {
      return (
        <SectionC>
          <Link to="/login">
            <HeaderButton>Iniciar sesión</HeaderButton>
          </Link>
          <Link to="/register">
            <HeaderButton>Crear cuenta</HeaderButton>
          </Link>
        </SectionC>
      );
    }
  };
  return (
    <HeaderC>
      <SectionC>
        <Link to="/">
          <Logo />
        </Link>
      </SectionC>
      {handleLoggin()}
    </HeaderC>
  );
};

export default Header;
