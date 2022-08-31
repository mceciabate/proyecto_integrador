import React from "react";
import { useState, useEffect } from "react";
import Card from "./Card";
import { ListC, ListDiv, ListH3 } from "../styles/ListStyles";

const List = ({ selectedCategory, title }) => {
  const [products, setProducts] = useState([]);
  useEffect(() => {
    if (selectedCategory === null) {
      const request = async () => {
        const response = await fetch(
          `http://13.59.92.254:8080/producto/listar`
        );
        const result = await response.json();
        setProducts(result);
      };
      request();
    } else {
      const request = async () => {
        const response = await fetch(
          `http://13.59.92.254:8080/producto/categoria/${selectedCategory}`
        );
        const result = await response.json();
        setProducts(result);
      };
    }
  }, []);
  const updatedProducts = [...products].sort((a, b) => a.id - b.id);
  console.log(title);
  return (
    <ListDiv>
      <ListH3>{(title === null) ? "Recomendaciones" : `Autos ${title}`}</ListH3>
      <ListC>
        {updatedProducts.map((product) => (
          <Card key={product.id} product={product} images={product.imagen} />
        ))}
      </ListC>
    </ListDiv>
  );
};

export default List;
