import React from "react";
import { HeaderC, SectionC, HeaderButton } from "../styles/HeaderStyles";
import logo from "../assets/logo.png";
import { Link } from "react-router-dom";

const Header = ({ isLogged }) => {
  return (
    <HeaderC>
      <SectionC>
        <Link to="/">
            <img src={logo} alt="logo" />
        </Link>
        <Link className="lema" to="/">Cars when and where you need</Link>
      </SectionC>
      {isLogged ? (
        <SectionC>
          <ul>Username</ul>
          <span>avatar</span>
          <HeaderButton>salir</HeaderButton>
        </SectionC>
      ) : (
        <SectionC>
          <HeaderButton>Log in</HeaderButton>
          <HeaderButton>Register</HeaderButton>
        </SectionC>
      )}
    </HeaderC>
  );
};

export default Header;
