import React from 'react';
import cars from '../data/cars.json';
import Card from './Card';
import { ListC } from '../styles/ListStyles';

const List = () => {
  return (
    <ListC>
        {cars.map(car => (
          <Card key={car.id} car={car} />
        ))}
    </ListC>
  );
}

export default List;