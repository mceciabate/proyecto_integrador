import React from "react";
import { CategoryCard, CategoryImage } from "../styles/CategoriesStyles";
import { Link } from "react-router-dom";

const CardCategories = ({ category }) => {
  console.log(category.imagenCategoria);
  return (
    <>
    <CategoryCard>
      <Link to={'/'}>
        <CategoryImage src={category.imagenCategoria.urlImg} alt={category.titulo} />
      </Link>
      <h3>{category.titulo}</h3>
      <p>807.105 carros</p>
    </CategoryCard>
    </>
  );
};

export default CardCategories;
