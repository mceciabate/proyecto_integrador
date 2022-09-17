import React from "react";
import { HeaderC, SectionC, HeaderButton, Logo, MenuButton, DeployMenu } from "../styles/HeaderMStyles";
import { Link } from "react-router-dom";
import { useEffect } from "react";
import { useState } from "react";

const Header = ({ isLogged, setIsLogged }) => {
  const [ deployMenu, setDeployMenu ] = useState(false);
  useEffect(()=>{
    if(window.localStorage.getItem('Token')){
      setIsLogged(true)
    } else {
      setIsLogged(false)
    }
  },[isLogged, setIsLogged])
  const menu = () => {
    return(
      <DeployMenu>
        <MenuButton onClick={()=> setDeployMenu(false)}/>
        <Link to="/login">
          <HeaderButton>Iniciar Sesión</HeaderButton>
        </Link>
        <Link to="/register">
          <HeaderButton>Registrarse</HeaderButton>
        </Link>
      </DeployMenu>
    )
  }
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
          <MenuButton onClick={() => setDeployMenu(true)}/>
          {(deployMenu) ? menu() : null}
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