import React from "react";
import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import {
  HeaderContainer,
  LHeader,
  RHeader,
  BodyContainer,
  FormContainer,
  ReserveContainer,
  CalendarContainer,
  Schedule,
  Detail,
} from "./ReserveStyles";
import arrow from "../../assets/arrow.png";
import Calendar from "react-calendar";
import "./calendarStyles.css";

const Reserve = () => {
  const getWindowSize = () => {
    const { innerWidth, innerHeight } = window;
    return { innerWidth, innerHeight };
  };
  const [windowSize, setWindowSize] = useState(getWindowSize());
  useEffect(() => {
    function handleWindowResize() {
      setWindowSize(getWindowSize());
    }

    window.addEventListener("resize", handleWindowResize);

    return () => {
      window.removeEventListener("resize", handleWindowResize);
    };
  }, []);
  return (
    <ReserveContainer>
      <HeaderContainer>
        <LHeader>
          <p>P category</p>
          <h1>p title</h1>
        </LHeader>
        <RHeader>
          <Link to="/">
            <img src={arrow} alt="home" className="arrow" />
          </Link>
        </RHeader>
      </HeaderContainer>
      <BodyContainer>
        <FormContainer>
          <h2>Completa tus datos</h2>
          <form>
            <label>
              Nombre
              <input required type="name" placeholder="Bruno" name="name" />
            </label>
            <label>
              Apellido
              <input
                required
                type="lastname"
                placeholder="Rodriguez"
                name="lastname"
              />
            </label>
            <label>
              Correo electronico
              <input
                required
                type="e-mail"
                placeholder="brodriguez@gmail.com"
                name="email"
              />
            </label>
            <label>
              Ciudad
              <input
                required
                type="city"
                placeholder="Rosario, Santa Fe"
                name="ciudad"
              />
            </label>
          </form>
        </FormContainer>
        <CalendarContainer>
          <h2>Selecciona tu fecha de reserva</h2>
          <Calendar
            showDoubleView={windowSize.innerWidth > 500 ? true : false}
            next2Label={null}
            prev2Label={null}
          />
        </CalendarContainer>
        <Schedule>
          <h2>Tus horarios</h2>
          <FormContainer>
            <h4>Tu auto va a estar listo para ti entra las</h4>
            <form>
              <label>
                Indica tu horario estimado de recogida
                <select></select>
              </label>
              <label>
                Indica tu lugar de recogida
                <select></select>
              </label>
              <label>
                Inidica tu horario estimado de entrega
                <select></select>
              </label>
              <label>
                Indica tu lugar de entrega
                <select></select>
              </label>
            </form>
          </FormContainer>
        </Schedule>
        <Detail>
          <h2 className="htop">Detalle de la reserva</h2>
          <img src="" alt="auto" />
          <div>
            <p className="pcategory">cat</p>
            <h2 className="hbottom">title</h2>
            <p className="pstars">stars</p>
            <p className="plocation">direction</p>
          </div>
          <div>
            <p className="paccion">Recogida</p>
            <p className="plugar">Lugar</p>
          </div>
          <div>
            <p className="paccion">Entrega</p>
            <p className="plugar">Lugar</p>
          </div>
          <button>Confirmar reserva</button>
        </Detail>
      </BodyContainer>
    </ReserveContainer>
  );
};

export default Reserve;
