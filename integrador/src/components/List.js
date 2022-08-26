import React from "react";
import { useState, useEffect } from "react";
import Card from "./Card";
import { ListC, ListDiv, ListH3 } from "../styles/ListStyles";

const List = () => {
  const [products, setProducts] = useState([])
  useEffect(() => {
    const request = async () => {
        const response = await fetch(
            `http://13.59.92.254:8080/producto/listar`
        );
        const result = await response.json();
        setProducts(result);
    };
    request();
  }, []);
  const updatedProducts = [...products].sort((a, b) => a.id - b.id);
  return (
    <ListDiv>
      <ListH3>Recomendaciones</ListH3>
      <ListC>
        {updatedProducts.map((product) => (
          <Card key={product.id} product={product} images={product.imagen} />
        ))}
      </ListC>
    </ListDiv>
  );
};

export default List;
