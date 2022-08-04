import React from "react";
import GoTo from "./GoTo";
import { HeaderC, SectionC, HeaderButton } from "../styles/HeaderStyles";

const Header = ({ isLogged }) => {
  return (
    <HeaderC>
      <SectionC>
        <GoTo className="logo" argumentOne="Logo" argumentTwo="/" />
        <GoTo className="Lema" argumentOne="Lema" argumentTwo="/" />
      </SectionC>
      {isLogged ? (
        <SectionC>
          <ul>nombre de usuario</ul>
          <span>avatar</span>
          <HeaderButton>salir</HeaderButton>
        </SectionC>
      ) : (
        <SectionC>
          <HeaderButton>Iniciar Sesion</HeaderButton>
          <HeaderButton>Registrarse</HeaderButton>
        </SectionC>
      )}
    </HeaderC>
  );
};

export default Header;