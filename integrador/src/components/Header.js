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
        <Link className="lema" to="/">
          Cars when and where you need
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
            <HeaderButton>Log in</HeaderButton>
          </Link>
          <Link to="/register">
            <HeaderButton >Register</HeaderButton>
          </Link>
        </SectionC>
      )}
    </HeaderC>
  );
};

export default Header;
