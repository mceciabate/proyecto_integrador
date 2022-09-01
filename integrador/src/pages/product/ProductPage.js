import React from "react";
import Product from "./Product";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

const ProductPage = () => {
  const { id } = useParams();
  const [policy, setPolicy] = useState([
    {
      id: undefined,
      titulo: "loading",
      descripcion: "loading",
    },
    {
      id: undefined,
      titulo: "loading",
      descripcion: "loading",
    },
  ]);
  const [images, setImages] = useState([{}]);
  const [product, setProduct] = useState({});
  useEffect(() => {
    const request = async () => {
      const response = await fetch(`http://13.59.92.254:8080/producto/${id}`);
      const result = await response.json();
      setProduct(result);
      setImages(result.imagen);
      /* setPolicy(result.politica); */
    };
    request();
  }, [id]);
  return <Product images={images} product={product} policy={policy} />;
};

export default ProductPage;
