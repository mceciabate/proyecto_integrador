import React, { useState } from "react";
import { HeaderC, SectionC, HeaderButton, Logo } from "../styles/HeaderDStyles";
import { Link } from "react-router-dom";
import { useEffect } from "react";

const Header = ({ isLogged, setIsLogged }) => {
  const [user, setUser] = useState("");
  useEffect(() => {
    setUser(window.localStorage.getItem("User"));
  }, [isLogged, user]);
  const handleLoggin = () => {
    if (isLogged) {
      return (
        <SectionC>
          <h3>{`Hola ${user}`}</h3>
          <span>SL</span>
          <HeaderButton
            onClick={() => {
              setIsLogged(false);
              window.localStorage.removeItem('User');
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
