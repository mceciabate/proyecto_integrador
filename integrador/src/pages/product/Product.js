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
import { Rating } from 'react-simple-star-rating'
import { Wrapper, Status } from "@googlemaps/react-wrapper"

const Product = ({ img }) => {
  const { id } = useParams();
  const [product, setProduct] = useState()
  useEffect(() => {
    const request = async () => {
        const response = await fetch(
            `http://18.219.33.103:8080/products`
        );
        const result = await response.json();
        setProduct(result[id]);
    };
    request();
  }, [id]);
  
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
  const render = (status) => {
    return <h1>{status}</h1>
  }
  console.log(product)
  return (
    <ProductContainer>
      <HeaderContainer>
        <LHeader>
          <p>a</p>
          <h1>{product.name}</h1>
          <div>
            <BsFillPinMapFill />
            <p></p>
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
        <h2>Disfruta un automóvil moderno y 100% eléctrico</h2>
        <p>
          Rentar un Renault Zoe te permite disfrutar un automóvil 100%
          Eléctrico, cuenta con una bateria de iones de litio con celdas de LG
          Chem, va situada debajo del habitaculo y refrigerada por aire
          (refrigeración pasiva), el conector "Camaleón" se adapta a diferentes
          intensidades y potencias disponibles, tanto en monofásico como en
          trifásico. En una carga semi rápida a 50W se puede conseguir 150 Km de
          autonomía en 30 minutos, obtener una carga al 80% en aproxímadamente 1
          hora y media, en la conexión habitual en los hogares que es de menor
          potencia le tomará aproxímadamente 10 horas para obtener una carga al
          100%.
        </p>
      </DescriptionContainer>
      <FeaturesContainer>
        <h2>¿Qué ofrece este auto?</h2>
        <div>
          <p>cocina</p>
          <p>televisor</p>
          <p>aire acondicionado</p>
          <p>parking</p>
          <p>pileta</p>
          <p>wifi</p>
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
