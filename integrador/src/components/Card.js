import React from "react";
import { CardC, StyledImg, CardDiv, StyledP1, StyledP2, StyledButton } from "../styles/ListStyles";
import { useNavigate } from "react-router-dom"

const Card = ({ car }) => {
  let navigate = useNavigate()
  const routeChange = () =>{
    let path = "/product"
    navigate(path)
  }
  return (
    <CardC>
      <div>
        <StyledImg src={car.img} alt={car.name} />
      </div>
      <CardDiv>
        <StyledP1>{car.category}</StyledP1>
        <h3>{car.title}</h3>
        <StyledP2>{car.location}</StyledP2>
        <StyledP2>{car.description}</StyledP2>
        <StyledButton onClick={routeChange} >ver mas</StyledButton>
      </CardDiv>
    </CardC>
  );
};

export default Card;
