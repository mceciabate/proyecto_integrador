import React from "react";
import { useState } from "react";
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
} from "./ProductStyles";
import { BsFillPinMapFill } from "react-icons/bs";
import arrow from "../../assets/arrow.png";
import { DateRange } from "react-date-range";
import "react-date-range/dist/styles.css";
import "react-date-range/dist/theme/default.css";

const Product = ({ product }) => {
  const [state, setState] = useState([
    {
      startDate: new Date(),
      endDate: null,
      key: "selection",
    },
  ]);
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
      <ImageContainer>
        <img src={arrow} alt="product" className="MainImg" />
        <img src={arrow} alt="product" className="SecondImg" />
        <img src={arrow} alt="product" className="ThirdImg" />
        <img src={arrow} alt="product" className="FourthImg" />
        <img src={arrow} alt="product" className="FifthImg" />
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
        <h2>¿Qué ofrece este lugar?</h2>
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
        <h2>Fechas disponibles</h2>
        <CalendarSection>
          <DateRange
              editableDateInputs={true}
              onChange={(item) => setState([item.selection])}
              moveRangeOnFirstSelection={false}
              ranges={state}
              rangeColors={["#F0572D"]}
            />
          <CalendarItem>
            <h3>Agregá tus fechas de viaje para obtener precios exactos</h3>
            <button>Iniciar reserva</button>
          </CalendarItem>
        </CalendarSection>
      </CalendarContainer>
      <div>
        {" "}
        "map"
        <h2>¿Dónde vas a estar? </h2>
        <p>m country</p>
        <div>map</div>
      </div>
      <div>
        <h2>Qué tenés que saber</h2>
        <div>
          <h4>Normas</h4>
          <p>c1 description</p>
        </div>
        <div>
          <h4>Seguridad</h4>
          <p>c2 description</p>
        </div>
        <div>
          <h4>Cancelacion</h4>
          <p>c3 description</p>
        </div>
      </div>
    </ProductContainer>
  );
};

export default Product;
