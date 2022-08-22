import React from "react";
import { HeaderC, SectionC, HeaderButton, Logo } from "../styles/HeaderDStyles";
import { Link } from "react-router-dom";

const Header = ({ isLogged, setIsLogged }) => {
  const handleLoggin = () => {
    if (isLogged) {
      return (
        <SectionC>
          <h3>Hola Simon</h3>
          <span>SL</span>
          <HeaderButton onClick={() => setIsLogged(false)}>
            Log out
          </HeaderButton>
        </SectionC>
      );
    } else {
      return (
        <SectionC>
          <Link to="/login">
            <HeaderButton>Iniciar sesion</HeaderButton>
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
