import React from "react";
import { CategoryCard, CategoryImage } from "../styles/CategoriesStyles";

const CardCategories = ({ category }) => {
  return (
    <CategoryCard>
      <CategoryImage src={`/img/${category.img}`} alt={category.caption}/>
      <h3>{category.caption}</h3>
      <p>{category.total}</p>
    </CategoryCard>
  )
}

export default CardCategories;