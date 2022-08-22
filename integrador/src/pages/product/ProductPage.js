import React from "react";
import Product from "./Product";


const arrawimg = ["https://assets.iprofesional.com/cdn-cgi/image/w=880,f=webp/https://assets.iprofesional.com/assets/jpg/2020/03/492392.jpg", "https://assets.iprofesional.com/cdn-cgi/image/w=880,f=webp/https://assets.iprofesional.com/assets/jpg/2020/03/492391.jpg", "https://assets.iprofesional.com/cdn-cgi/image/w=880,f=webp/https://assets.iprofesional.com/assets/jpg/2020/03/492394.jpg", "https://assets.iprofesional.com/cdn-cgi/image/w=880,f=webp/https://assets.iprofesional.com/assets/jpg/2020/03/492395.jpg", "https://assets.iprofesional.com/cdn-cgi/image/w=880,f=webp/https://assets.iprofesional.com/assets/jpg/2020/03/492390.jpg"];

const ProductPage = () => {
  return <Product product={arrawimg} />;
}

export default ProductPage;