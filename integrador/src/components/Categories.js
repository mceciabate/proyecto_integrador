import React from "react";
import CardCategories from "./CardCategories";
import { useState, useEffect } from "react";
import { CategoriesContainer, CardContainer } from "../styles/CategoriesStyles";

const Categories = ({ handleCategory }) => {
  const [categories, setCategories] = useState([]);
  useEffect(() => {
    const request = async () => {
      const response = await fetch(`http://13.59.92.254:8080/categoria/listar`);
      const result = await response.json();
      setCategories(result);
    };
    request();
  }, []);
  return (
    <CategoriesContainer>
      <h2>Buscar por tipo</h2>
      <CardContainer>
        {categories.map((category) => (
          <div key={category.id} onClick={()=>handleCategory(category)}>
          <CardCategories
            key={category.id}
            category={category}
          />
          </div>
        ))}
      </CardContainer>
    </CategoriesContainer>
  );
};

export default Categories;
