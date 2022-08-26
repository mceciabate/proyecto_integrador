import React from "react";
import Product from "./Product";
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom'

const arrawimg = ["https://assets.iprofesional.com/cdn-cgi/image/w=880,f=webp/https://assets.iprofesional.com/assets/jpg/2020/03/492392.jpg", "https://assets.iprofesional.com/cdn-cgi/image/w=880,f=webp/https://assets.iprofesional.com/assets/jpg/2020/03/492391.jpg", "https://assets.iprofesional.com/cdn-cgi/image/w=880,f=webp/https://assets.iprofesional.com/assets/jpg/2020/03/492394.jpg", "https://assets.iprofesional.com/cdn-cgi/image/w=880,f=webp/https://assets.iprofesional.com/assets/jpg/2020/03/492395.jpg", "https://assets.iprofesional.com/cdn-cgi/image/w=880,f=webp/https://assets.iprofesional.com/assets/jpg/2020/03/492390.jpg"];

const ProductPage = () => {
  const { id } = useParams()
  const [product, setProduct] = useState({})
  useEffect(() => {
    const request = async () => {
        const response = await fetch(
            `http://localhost:8080/producto/${id}`
        );
        const result = await response.json();
        setProduct(result);
    };
    request();
  },[id]);
  console.log(product)
  return <Product img={arrawimg} product={product}/>;
}

export default ProductPage;