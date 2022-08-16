import React from 'react';
import Searcher from '../../components/Searcher';
import List from '../../components/List';
import Categories from '../../components/Categories';

const Home = () => {
  return (
    <div>
      <Searcher />
      <Categories/>
      <List />
    </div>
  );
}

export default Home;