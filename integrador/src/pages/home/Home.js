import React, { useState } from 'react';
import Searcher from '../../components/Searcher';
import List from '../../components/List';
import Categories from '../../components/Categories';

const Home = () => {
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [title, setTitle] = useState("");
  const [selectedCity, setSelectedCity] = useState(null);
  return (
    <div>
      <Searcher />
      <Categories setSelectedCategory={setSelectedCategory} setTitle={setTitle} />
      <List selectedCategory={selectedCategory} title={title} />
    </div>
  );
}

export default Home;