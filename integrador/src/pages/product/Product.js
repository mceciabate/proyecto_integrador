import React from "react";
import { useState, useEffect } from "react";
import { Link, useParams } from "react-router-dom";
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
import { Rating } from 'react-simple-star-rating';
const Product = ({ img }) => {
  const { id } = useParams();
  const [product, setProduct] = useState({})
  useEffect(() => {
    const request = async () => {
        const response = await fetch(
            `http://18.219.33.103:8080/products`
        );
        const result = await response.json();
        setProduct(result[id]);
    };
    request();
  },);
  
  const getWindowSize = () => {
    const { innerWidth, innerHeight } = window;
    return { innerWidth, innerHeight };
  };

  const [rating, setRating] = useState(0)
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
    setRating(rate)
  }
  return (
    <ProductContainer>
      <HeaderContainer>
        <LHeader>
          <p>{product.category && product.category.name}</p>
          <h1>{product && product.name}</h1>
          <div>
            <BsFillPinMapFill />
            <p>{product.city && product.city.name}</p>
          </div>
        </LHeader>
        <RHeader>
          <Link to="/">
            <img src={arrow} alt="home" className="arrow" />
          </Link>
          <Rating onClick={hanldeRating} ratingValue={rating} size={(windowSize.innerWidth > 700) ? 25 : 15} fillColor={"#f0572d"} allowHalfIcon={true} transition={true} />
        </RHeader>
      </HeaderContainer>
      {showModal && (
        <ProductGallery
          pictures={img}
          current={currentIndex}
          handleClose={() => setShowModal(false)}
          setCurrentIndex={setCurrentIndex}
        />
      )}
      <ImageContainer>
        {img.map((pic, index) => (
          <div
            className={index === 0 ? "main-image" : "image"}
            onClick={() => handleModal(index)}
            key={index}
          >
            <img src={pic} alt="product" />
          </div>
        ))}
      </ImageContainer>
      <DescriptionContainer>
        <h2>Disfruta un automóvil pensado para tus necesidades</h2>
        <p>{product && product.description}</p>
      </DescriptionContainer>
      <FeaturesContainer>
        <h2>¿Qué ofrece este auto?</h2>
        <div>
          <p>bluetooth</p>
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
            <h4>Normas</h4>
            <p>norma</p>
            <p>norma</p>
            <p>norma</p>
          </FooterItem>
          <FooterItem>
            <h4>Seguridad</h4>
            <p>seguridad</p>
            <p>seguridad</p>
            <p>seguridad</p>
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
