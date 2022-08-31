import React from "react";
import { FooterC, FooterUl } from "../styles/FooterStyles";
import { Icon } from "@iconify/react";
import isologo from "../assets/isologo.png";

const Footer = () => {
  return (
    <FooterC>
      <FooterUl>
        <img src={isologo} alt="isologo" />
        <li>@2022</li>
        <li>UbiCar</li>
      </FooterUl>
      <FooterUl>
        <Icon icon="akar-icons:facebook-fill" />
        <Icon icon="akar-icons:twitter-fill" />
        <Icon icon="akar-icons:instagram-fill" />
      </FooterUl>
    </FooterC>
  );
};

export default Footer;