import React from "react";
import { CardC, StyledImg, CardDiv, StyledP1, StyledP2, StyledButton } from "../styles/ListStyles";
import { Link } from "react-router-dom"

const Card = ({ product }) => {
  return (
    <CardC>
      <div>
        <StyledImg src={product.imagen && product.imagen[0].url} alt={product.name} />
      </div>
      <CardDiv>
        <StyledP1>{product.categoria.titulo}</StyledP1>
        <h3>{product.titulo}</h3>
        <StyledP2>{product.ciudad.localidad}</StyledP2>
        <StyledP2>{product.descripcion}</StyledP2>
        <Link to={`product/${product.id}`} >
        <StyledButton>ver mas</StyledButton>
        </Link>
      </CardDiv>
    </CardC>
  );
};

export default Card;
