import React from "react";
import cars from "../data/cars.json";
import Card from "./Card";
import { ListC, ListDiv, ListH3 } from "../styles/ListStyles";

const List = () => {
  return (
    <ListDiv>
      <ListH3>Recomendaciones</ListH3>
      <ListC>
        {cars.map((car) => (
          <Card key={car.id} car={car} />
        ))}
      </ListC>
    </ListDiv>
  );
};

export default List;
