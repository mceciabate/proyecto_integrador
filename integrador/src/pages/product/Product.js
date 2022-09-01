import React from "react";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import {
  ProductContainer,
  HeaderContainer,
  LHeader,
  RHeader,
  ImageContainer,
  DescriptionContainer,
  FeaturesContainer,
  MyH2,
  CalendarContainer,
  CalendarSection,
  CalendarItem,
  FooterContainer,
  FooterItemContainer,
  FooterItem,
} from "./ProductStyles";
import { BsFillPinMapFill } from "react-icons/bs";
import arrow from "../../assets/arrow.png";
import "react-date-range/dist/styles.css";
import "react-date-range/dist/theme/default.css";
import ProductGallery from "./ProductGallery";
import Calendar from "react-calendar";
import "./calendarStyles.css";
import { Rating } from "react-simple-star-rating";
const Product = ({ images, product, policy }) => {
  const getWindowSize = () => {
    const { innerWidth, innerHeight } = window;
    return { innerWidth, innerHeight };
  };
  const [rating, setRating] = useState(0);
  const [windowSize, setWindowSize] = useState(getWindowSize());
  const [showModal, setShowModal] = useState(false);
  const [currentIndex, setCurrentIndex] = useState(0);

  useEffect(() => {
    if (showModal) {
      document.body.style.overflow = "hidden";
    } else {
      document.body.style.removeProperty("overflow");
    }
  }, [showModal]);

  useEffect(() => {
    function handleWindowResize() {
      setWindowSize(getWindowSize());
    }

    window.addEventListener("resize", handleWindowResize);

    return () => {
      window.removeEventListener("resize", handleWindowResize);
    };
  }, []);

  const handleModal = (index) => {
    setCurrentIndex(index);
    setShowModal(true);
  };
  const hanldeRating = (rate) => {
    setRating(rate);
  };
  const updatedImg = [...images].sort((a, b) => a.id - b.id);
  updatedImg.pop();
  return (
    <ProductContainer>
      <HeaderContainer>
        <LHeader>
          <p>{product.categoria && product.categoria.titulo}</p>
          <h1>{product && product.titulo}</h1>
          <div>
            <BsFillPinMapFill />
            <p>{product && product.ciudad && product.ciudad.localidad}</p>
          </div>
        </LHeader>
        <RHeader>
          <Link to="/">
            <img src={arrow} alt="home" className="arrow" />
          </Link>
          <Rating
            onClick={hanldeRating}
            ratingValue={rating}
            size={windowSize.innerWidth > 700 ? 25 : 15}
            fillColor={"#f0572d"}
            allowHalfIcon={true}
            transition={true}
          />
        </RHeader>
      </HeaderContainer>
      {showModal && (
        <ProductGallery
          arrayImg={updatedImg}
          current={currentIndex}
          handleClose={() => setShowModal(false)}
          setCurrentIndex={setCurrentIndex}
        />
      )}
      <ImageContainer>
        {updatedImg.map((pic, index) => (
          <div
            className={index === 0 ? "main-image" : "image"}
            onClick={() => handleModal(index)}
            key={index}
          >
            <img src={pic.urlImg} alt={pic.titulo} />
          </div>
        ))}
      </ImageContainer>
      <DescriptionContainer>
        <h2>Disfruta un automóvil pensado para tus necesidades</h2>
        <p>{product && product.descripcion}</p>
      </DescriptionContainer>
      <FeaturesContainer>
        <h2>¿Qué ofrece este auto?</h2>
        <div>
          git
          <p>gps</p>
          <p>automaticp</p>
          <p>parking</p>
          <p>feature</p>
          <p>feature</p>
        </div>
      </FeaturesContainer>
      <MyH2>Fechas disponibles</MyH2>
      <CalendarContainer>
        <Calendar
          showDoubleView={windowSize.innerWidth > 500 ? true : false}
          next2Label={null}
          prev2Label={null}
        />
        <CalendarSection>
          <CalendarItem>
            <h3>Agregá tus fechas de viaje para obtener precios exactos</h3>
            <button>Iniciar reserva</button>
          </CalendarItem>
        </CalendarSection>
      </CalendarContainer>
      <div></div>
      <FooterContainer>
        <h2>Qué tenés que saber</h2>
        <FooterItemContainer>
          <FooterItem>
            <h4>
              {policy[0].titulo === undefined ? "loading" : policy[0].titulo}
            </h4>
            <p>
              {policy[0].descripcion === undefined
                ? "loading"
                : policy[0].descripcion}
            </p>
          </FooterItem>
          <FooterItem>
            <h4>
              {policy[1].titulo === undefined ? "loading" : policy[1].titulo}
            </h4>
            <p>
              {policy[1].descripcion === undefined
                ? "loading"
                : policy[1].descripcion}
            </p>
          </FooterItem>
          <FooterItem>
            <h4>Cancelacion</h4>
            <p>cancelacion</p>
            <p>cancelacion</p>
            <p>cancelacion</p>
          </FooterItem>
        </FooterItemContainer>
      </FooterContainer>
    </ProductContainer>
  );
};

export default Product;
