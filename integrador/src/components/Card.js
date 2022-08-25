import React from "react";
import { CardC, StyledImg, CardDiv, StyledP1, StyledP2, StyledButton } from "../styles/ListStyles";
import { useNavigate, Link } from "react-router-dom"

const Card = ({ product }) => {
  let navigate = useNavigate()
  const routeChange = () =>{
    let path = `product/${product.id}`
    navigate(path)
  }
  return (
    <CardC>
      <div>
        <StyledImg src={product.images[0].url} alt={product.name} />
      </div>
      <CardDiv>
        <StyledP1>{product.category.name}</StyledP1>
        <h3>{product.name}</h3>
        <StyledP2>{product.city.name}</StyledP2>
        <StyledP2>{product.description}</StyledP2>
        <Link to={`product/${product.id}`} >
        <StyledButton>ver mas</StyledButton>
        </Link>
      </CardDiv>
    </CardC>
  );
};

export default Card;
