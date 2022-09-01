import React from "react";
import { useState, useEffect } from "react";
import "react-calendar/dist/Calendar.css";
import {
  SearchContainer,
  SearchForm,
  SearchSelect,
  SearchButton,
  CalendarDiv,
  CalendarButton,
  IconSelect,
} from "../styles/SearcherStyles";
import { DateRange } from "react-date-range";
import "react-date-range/dist/styles.css";
import "react-date-range/dist/theme/default.css";
import { BsCalendarCheck } from "react-icons/bs";
import { BsFillPinMapFill } from "react-icons/bs";
import { Icon } from "@iconify/react";

const Searcher = ( {setCity} ) => {
  const [cities, setCities] = useState([{}]);
  const [selectedCity, setSelectedCity] = useState(null);
  useEffect(() => {
    const request = async () => {
      const response = await fetch(`http://13.59.92.254:8080/ciudad`);
      const result = await response.json();
      setCities(result);
    };
    request();
  },[]);
  const [state, setState] = useState([
    {
      startDate: new Date(),
      endDate: null,
      key: "selection",
    },
  ]);
  const [showCalendar, setshowCalendar] = useState(false);
  const updatedCities = [...cities].sort((a, b) => a.id - b.id);
  return (
    <SearchContainer>
      <h1>La forma mas facil y segura de rentar tu carro</h1>
      <SearchForm onSubmit={(e)=>{
            e.preventDefault();
            setshowCalendar(false);
            setCity(selectedCity);
      }}>
        <IconSelect>
          <BsFillPinMapFill className="icon" />
          <SearchSelect onChange={(e)=>{
            const value = e.target.value;
            setSelectedCity(value)}} required>
            <option value="S">Recogida</option>
            {updatedCities.map((city, index) => (
              <option key={index} value={city.localidad}>
                {city.localidad + " , " + city.provincia}
              </option>
            ))}
          </SearchSelect>
        </IconSelect>
        <IconSelect>
          <BsFillPinMapFill className="icon" />
          <SearchSelect required>
          <option value="S">Devolucion</option>
            {updatedCities.map((city, index) => (
              <option key={index} value={city.localidad}>
                {city.localidad + " , " + city.provincia}
              </option>
            ))}
          </SearchSelect>
        </IconSelect>
        {showCalendar ? (
          <CalendarDiv>
            <DateRange
              editableDateInputs={true}
              onChange={(item) => setState([item.selection])}
              moveRangeOnFirstSelection={false}
              ranges={state}
              rangeColors={["#F0572D"]}
            />
          </CalendarDiv>
        ) : (
          <CalendarButton onClick={() => setshowCalendar(true)}>
            <BsCalendarCheck className="icon" />
            Recogida - Devolucion
          </CalendarButton>
        )}
        <SearchButton type="submit">
          Buscar Carro
        </SearchButton>
      </SearchForm >
    </SearchContainer>
  );
};

export default Searcher;
