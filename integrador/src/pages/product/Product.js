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

const Product = ({ product }) => {
  const getWindowSize = () => {
    const { innerWidth, innerHeight } = window;
    return { innerWidth, innerHeight };
  };
  const [windowSize, setWindowSize] = useState(getWindowSize());
  const [date, setDate] = useState([
    {
      startDate: new Date(),
      endDate: null,
      key: "selection",
    },
  ]);
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
  console.log(showModal);
  console.log(currentIndex);
  return (
    <ProductContainer>
      <HeaderContainer>
        <LHeader>
          <p>p category</p>
          <h1>p name</h1>
          <div>
            <BsFillPinMapFill />
            <p>p location</p>
          </div>
        </LHeader>
        <RHeader>
          <Link to="/">
            <img src={arrow} alt="home" className="arrow" />
          </Link>
          <p>estrellas</p>
        </RHeader>
      </HeaderContainer>
      {showModal && (
        <ProductGallery
          pictures={product}
          current={currentIndex}
          handleClose={() => setShowModal(false)}
          setCurrentIndex={setCurrentIndex}
        />
      )}
      <ImageContainer>
        {product.map((pic, index) => (
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
      <CalendarContainer>
        <Calendar
          showDoubleView={windowSize.innerWidth > 480 ? true : false}
          next2Label={null}
          prev2Label={null}
        />
        <CalendarSection>
          <h2>Fechas disponibles</h2>
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
