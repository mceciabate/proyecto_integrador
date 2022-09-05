import React from "react";
import { useState, useEffect } from "react";
import Card from "./Card";
import { ListC, ListDiv, ListH3 } from "../styles/ListStyles";

const List = ({selectedCity,selectedCategory, cat}) => {
  const [products, setProducts] = useState([]);
  const [title, setTitle] = useState("Recomendaciones")
  useEffect(() => {
    let apiProducts = [];
    const request = async () => {
      const response = await fetch(`http://13.59.92.254:8080/producto/listar`);
      const result = await response.json();
      apiProducts=result;
    };
    request().then(()=>{
      if(selectedCategory && selectedCity) {
        const filteredProducts = apiProducts.filter(car => car.categoria.id === selectedCategory && car.ciudad.localidad === selectedCity);
        setProducts(filteredProducts);
        setTitle(`Autos ${cat} en ${selectedCity}`)
      } else if(selectedCity) {
        const productsByCity = apiProducts.filter(car => car.ciudad.localidad === selectedCity )
        setProducts(productsByCity);
        setTitle(`Autos en ${selectedCity}`)
      } else if (selectedCategory) {
        const productsByCategory = apiProducts.filter(car => car.categoria.id === selectedCategory);
        setProducts(productsByCategory);
        setTitle(`Autos ${cat}`)
      } else return setProducts(apiProducts);
    })
  }, [selectedCategory, selectedCity, cat]);
  console.log(products)
  return (
    <ListDiv>
      <ListH3>{title}</ListH3>
      <ListC>
        {products && products.sort((a, b) => a.id - b.id).map((product) => (
          <Card key={product.id} product={product} images={product.imagen} />
        ))}
      </ListC>
    </ListDiv>
  );
};

export default List;
