import React from "react";
import categories from "../data/categories";
import CardCategories from "./CardCategories";
import { CategoriesContainer, CardContainer } from "../styles/CategoriesStyles";

const Categories = () => {
  return (
    <CategoriesContainer>
      <h2>Buscar por tipo</h2>
      <CardContainer>
        {categories.map((category) => (
            <CardCategories key={category.id} category={category} />
        ))}
      </CardContainer>
    </CategoriesContainer>
  );
};

export default Categories;
