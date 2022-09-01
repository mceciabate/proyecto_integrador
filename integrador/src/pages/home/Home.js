import React, { useState } from "react";
import Searcher from "../../components/Searcher";
import List from "../../components/List";
import Categories from "../../components/Categories";

const Home = () => {
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [title, setTitle] = useState("");
  const [selectedCity, setSelectedCity] = useState(null);
  const handleCategory = (category) => {
    setSelectedCategory(category.id);
    setTitle(category.titulo);
  };
  return (
    <div>

      <Searcher setCity={setSelectedCity}/>
      <Categories handleCategory={handleCategory} />
      <List cat={title} selectedCity={selectedCity} selectedCategory={selectedCategory}/>
    </div>
  );
};

export default Home;
