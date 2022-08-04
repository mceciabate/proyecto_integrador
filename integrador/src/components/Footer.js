import React from "react";
import { FooterC, FooterUl } from "../styles/FooterStyles";
import { Icon } from "@iconify/react";

const Footer = () => {
  return (
    <FooterC>
      <FooterUl>
        <li>isologotipo</li>
        <li>anio</li>
        <li>copyright</li>
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