import React from "react";
import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import {
  HeaderContainer,
  LHeader,
  RHeader,
  BodyContainer,
  FormContainer as FormContainer,
  ReserveContainer,
  CalendarContainer,
  Schedule,
  Detail,
  MainButton,
  FormContainer2 
} from "./ReserveStyles";
import { useParams } from "react-router-dom";
import arrow from "../../assets/arrow.png";
import Calendar from "react-calendar";
import "./calendarStyles.css";
import TimePicker from "react-bootstrap-time-picker";


const Reserve = () => {
  const { id } = useParams();
  const [product, setProduct] = useState({})
  const [images, setImages] = useState([{}]);
  const [hour,setHour] = useState();
  const [hour1,setHour1] = useState();
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
  const [cities, setCities] = useState([{}]);
  const [selectedCity, setSelectedCity] = useState(null);
  const [selectedCity2, setSelectedCity2] = useState(null);
  useEffect(() => {
    const request = async () => {
      const response = await fetch(`http://13.59.92.254:8080/ciudad`);
      const result = await response.json();
      setCities(result);
    };
    request();
  },[]);
  const updatedCities = [...cities].sort((a, b) => a.id - b.id);
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

  console.log(images)
  return (
    <ReserveContainer>
      <HeaderContainer>
        <LHeader>
          <p>{product.categoria && product.categoria.titulo}</p>
          <h1>{product && product.titulo}</h1>
        </LHeader>
        <RHeader>
          <Link to="/">
            <img src={arrow} alt="home" className="arrow" />
          </Link>
        </RHeader>
      </HeaderContainer>
      <BodyContainer>
        <FormContainer>
        <h2 >Completa tus datos</h2>
          <form >
            <label >
              Nombre
              <input required type="name" placeholder="Bruno" name="name" />
            </label>
            <label >
              Apellido
              <input
                required
                type="lastname"
                placeholder="Rodriguez"
                name="lastname"
              />
            </label>
            <label >
              Correo electronico
              <input
                required
                type="e-mail"
                placeholder="brodriguez@gmail.com"
                name="email"
              />
            </label>
            <label id="label1">
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
          <FormContainer2>
            <form>
            <div class="form-title">
            <h4>Tu auto va a estar listo para ti entra las {hour} y {hour1}</h4>
            </div>
            <div></div>
              <label>
                Indica tu horario estimado de recogida
              <TimePicker start="00:00" end="23:59" step={1} value={hour} onChange={setHour}/>
              </label>
              <label>
                Indica tu lugar de recogida
                <select onChange={(e)=>{
                const value = e.target.value;
                setSelectedCity(value)}} required>
                <option value="S">Recogida</option>
                {updatedCities.map((city, index) => (
                  <option key={index} value={city.localidad}>
                    {city.localidad + " , " + city.provincia}
                </option>
                  ))}
                </select>
              </label>
              <label>
                Inidica tu horario estimado de entrega
                <TimePicker start="00:00" end="23:59" step={1} value = {hour1} onChange ={setHour1}/>
              </label>
              <label>
                Indica tu lugar de entrega
                <select onChange={(e)=>{
                const value = e.target.value;
                setSelectedCity2(value)}} required><option value="S">Devolucion</option>
                {updatedCities.map((city, index) => (
                <option key={index} value={city.localidad}>
                  {city.localidad + " , " + city.provincia}
                </option>
                ))}
                </select>
              </label>
            </form>
          </FormContainer2>
        </Schedule>
        <Detail>
          <h2 className="htop">Detalle de la reserva</h2>
          <img src={images && images[0].urlImg} alt="auto" />
          <div>
            <p className="pcategory">{product.categoria && product.categoria.titulo}</p>
            <h2 className="hbottom">{product && product.titulo}</h2>
            <p className="pstars">stars</p>
            <p className="plocation">{product.ciudad && product.ciudad.provincia}</p>
          </div>
          <div>
            <p className="paccion">Recogida: {hour}</p>
            <p className="plugar">Lugar: {selectedCity}</p>
          </div>
          <div>
            <p className="paccion">Entrega: {hour1}</p>
            <p className="plugar">Lugar: {selectedCity2}</p>
          </div>
          <MainButton>Confirmar reserva</MainButton>
        </Detail>
      </BodyContainer>
    </ReserveContainer>
  );
};

export default Reserve;
