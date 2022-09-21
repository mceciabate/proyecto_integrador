import React from "react";
import { HeaderC, SectionC, HeaderButton, Logo } from "../styles/HeaderDStyles";
import { Link } from "react-router-dom";
import { useState, useEffect } from "react";

const Header = ({ isLogged, setIsLogged }) => {
  const [isAdmin, setIsAdmin] = useState(false);
  useEffect(() => {
    if (window.localStorage.getItem("UserType") === "ADMINISTRADOR") {
      setIsAdmin(true);
    } else {
      setIsAdmin(false);
    }
  }, [isLogged]);
  const handleLoggin = () => {
    if (window.localStorage.getItem("Token")) {
      return (
        <SectionC>
          <h3>{`Hola ${window.localStorage.getItem(
            "Username"
          )} ${window.localStorage.getItem("Lastname")}`}</h3>
          <span>{`${window.localStorage
            .getItem("Username")
            .charAt(0)
            .toUpperCase()}${window.localStorage
            .getItem("Lastname")
            .charAt(0)
            .toUpperCase()}`}</span>
          {isAdmin && (
            <Link to={'/administracion'}>
              <span>
                ADMIN
              </span>
            </Link>
          )}
          <HeaderButton
            onClick={() => {
              setIsLogged(false);
              window.localStorage.removeItem("Token");
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
