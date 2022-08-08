import React from "react";
import { CardC } from "../styles/ListStyles";

const Card = ({ car }) => {
  return (
    <CardC>
      <div className="card-image">
        <img src={car.img} alt={car.name} />
      </div>
      <div className="card-content">
        <p>{car.category}</p>
        <h3>{car.title}</h3>
        <p>{car.location}</p>
        <p>{car.description}</p>
        <button>Ver detalle</button>
      </div>
    </CardC>
  );
};

export default Card;
