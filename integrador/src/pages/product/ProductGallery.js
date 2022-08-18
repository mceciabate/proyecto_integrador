import React from "react";
import { GalleryContainer, GalleryItem } from "./ProductStyles";

const ProductGallery = ({ pictures, current, handleClose, setCurrentIndex }) => {
  const handleArrow = () => {
    if (current === 4) {
      setCurrentIndex(0);
    } else {
      setCurrentIndex(current + 1);
    }
  };

  return (
    <GalleryContainer>
      <GalleryItem>
        <button onClick={handleClose}>X</button>
        {current != null && (
          <>
            <div style={{ width: "100%", border: "2px solid blue" }}>
              <img
                style={{ width: "200px", height: "200px" }}
                src={pictures[current]}
                alt="product"
              />
              <button onClick={() => handleArrow()}>></button>
            </div>
            <div style={{display: "grid", gridTemplateColumns: "1fr 1fr 1fr 1fr 1fr", gap: "8px" }}>
              {pictures.map((pic, index) => (
                <img
                  onClick={() => setCurrentIndex(index)}
                  src={pic}
                  alt="product"
                  style={{ width: "100%", height: "auto" }}
                  key={index}
                />
              ))}
            </div>
          </>
        )}
      </GalleryItem>
    </GalleryContainer>
  );
};

export default ProductGallery;
