import React from "react";
import { CategoryCard, CategoryImage } from "../styles/CategoriesStyles";
import { Link } from "react-router-dom";

const CardCategories = ({ category }) => {
  return (
    <>
    <CategoryCard>
        <CategoryImage src={category.imagenCategoria.urlImg} alt={category.titulo} />
      <h3>{category.titulo}</h3>
      <p>807.105 carros</p>
    </CategoryCard>
    </>
  );
};

export default CardCategories;
