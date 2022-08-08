import React from "react";
import { useState, useEffect } from "react";

const Categories = () => {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    const request = async () => {
      const response = await fetch(
        ""
      );
      const result = await response.json();
      setCategories(result);
    };
    request();
  } , []);


  return (
    <div>
      <h2>Categorías</h2>
      <p></p>
      <div>
        {categories.map((category) => (
          <div key={category.id}>
            <h3>{category.img}</h3>
            <p>{category.caption}</p>
          </div>
          ))}
      </div>
    </div>
  )
}

export default Categories;