import React from "react";
import { CategoryCard, CategoryImage } from "../styles/CategoriesStyles";

const CardCategories = ({ category }) => {
  console.log(category.urlImg);
  return (
    <CategoryCard>
      <CategoryImage src={`${category.urlImg}.jpg`} alt={category.titulo}/>
      <h3>{category.titulo}</h3>
      <p>807.105 carros</p>
    </CategoryCard>
  )
}

export default CardCategories;