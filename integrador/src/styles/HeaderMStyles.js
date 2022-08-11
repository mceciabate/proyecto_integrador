import styled from "styled-components";
import logo2 from "../assets/logoletra.png";
import menu from "../assets/menu.png";

export const HeaderC = styled.header`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100vw;
  height: 10vh;
  background-color: transparent;
  @media only screen and (min-width: 482px) {
    display: none;
  }
`;

export const SectionC = styled.section`
  margin: 15px 30px 15px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 25px;
`;

export const MenuButton = styled.button`
  width: 25px;
  height: 25px;
  background: url(${menu}) no-repeat center center;
  border: none;
`

export const HeaderButton = styled.button`
  font-weight: 100;
  border: 1px solid #F0572D;
  background-color: #F0572D;
  color: white;
  box-shadow: 0 0 30px rgba(125, 33, 129, 0.4);
  height: 2rem;
  width: 10rem;
  border-radius: 10px;
  cursor: pointer;
`;

export const Logo = styled.div`
  background: url(${logo2});
  background-repeat: no-repeat;
  width: 105px;
  height: 55px;
  margin-top: 10px;
`