import React from "react";
import { GalleryContainer, GalleryItem, GalleryButton, MainImageContainer, MainImage, ArrowButton, Carrousel, CarrouselImg } from "./ProductStyles";

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
        <GalleryButton onClick={handleClose}>X</GalleryButton>
        {current != null && (
          <div>
            <MainImageContainer>
              <MainImage
                src={pictures[current]}
                alt="product"
              />
              <ArrowButton onClick={() => handleArrow()}>></ArrowButton>
            </MainImageContainer>
            <Carrousel>
              {pictures.map((pic, index) => (
                index!==current && (
                <CarrouselImg
                  onClick={() => setCurrentIndex(index)}
                  src={pic}
                  alt="product"
                  key={index}
                />
                )
              ))}
            </Carrousel>
          </div>
        )}
      </GalleryItem>
    </GalleryContainer>
  );
};

export default ProductGallery;
