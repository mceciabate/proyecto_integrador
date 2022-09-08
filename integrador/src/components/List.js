import React from "react";
import { useState, useEffect } from "react";
import Card from "./Card";
import { ListC, ListDiv, ListH3 } from "../styles/ListStyles";

const List = ({ selectedCity, selectedCategory, cat, selectedDates }) => {
  const [products, setProducts] = useState([]);
  const [title, setTitle] = useState("Recomendaciones");
  useEffect(() => {
    let apiProducts = [];
    const request = async () => {
      if (selectedDates && !selectedCity) {
        const formatedStartDate = `${selectedDates[0].startDate.getDate()}-${selectedDates[0].startDate.getMonth()}-${selectedDates[0].startDate.getFullYear()}`;
        const formatedEndDate = `${selectedDates[0].endDate.getDate()}-${selectedDates[0].endDate.getMonth()}-${selectedDates[0].endDate.getFullYear()}`;
        const response = await fetch(
          `http://13.59.92.254:8080/disponible/${formatedEndDate}/${formatedStartDate}/${selectedCity}`,
          {
            method: "GET",
            headers: { "Content-Type": "application/json; charset=utf-8" },
          }
        );
        const result = await response.json();
        apiProducts = result;
      } else {
        const response = await fetch(
          `http://13.59.92.254:8080/producto/listar`
        );
        const result = await response.json();
        apiProducts = result;
      }
    };
    request().then(() => {
      if (selectedCategory) {
        const productsByCategory = apiProducts.filter(
          (car) => car.categoria.id === selectedCategory
        );
        setProducts(productsByCategory);
        setTitle(`Autos ${cat}`);
      } else return setProducts(apiProducts);
    });
  }, [selectedCategory, selectedCity, cat, selectedDates]);
  return (
    <ListDiv>
      <ListH3>{title}</ListH3>
      <ListC>
        {products &&
          products
            .sort((a, b) => a.id - b.id)
            .map((product) => (
              <Card
                key={product.id}
                product={product}
                images={product.imagen}
              />
            ))}
      </ListC>
    </ListDiv>
  );
};

export default List;
