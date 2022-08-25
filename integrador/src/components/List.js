import React from "react";
import { useState, useEffect } from "react";
import Card from "./Card";
import { ListC, ListDiv, ListH3 } from "../styles/ListStyles";

const List = () => {
  const [products, setProducts] = useState([])
  useEffect(() => {
    const request = async () => {
        const response = await fetch(
            `http://localhost:8080/producto`
        );
        const result = await response.json();
        setProducts(result);
    };
    request();
  }, []);
  return (
    <ListDiv>
      <ListH3>Recomendaciones</ListH3>
      <ListC>
        {products.map((product) => (
          <Card key={product.id} product={product} />
        ))}
      </ListC>
    </ListDiv>
  );
};

export default List;
