import React from "react";
import { useState, useEffect } from "react";
import Card from "./Card";
import { ListC, ListDiv, ListH3 } from "../styles/ListStyles";

const FilteredList = ({ selectedCategory, title }) => {
  const [products, setProducts] = useState([]);
  useEffect(() => {
    const request = async () => {
      const response = await fetch(`http://13.59.92.254:8080/producto/categoria/${selectedCategory}`);
      const result = await response.json();
      setProducts(result);
    };
    request();
  }, [selectedCategory]);
  
  const updatedProducts = [...products].sort((a, b) => a.id - b.id);
  console.log("yeah")
  return (
    <ListDiv>
      <ListH3>{(title !== "") ? `Autos ${title}` : `Recomendaciones`}</ListH3>
      <ListC>
        {updatedProducts.map((product, index) => (
          <Card key={index} product={product} images={product.imagen} />
        ))}
      </ListC>
    </ListDiv>
  );
};

export default FilteredList;