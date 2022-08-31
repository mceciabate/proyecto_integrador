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

const Searcher = () => {
  const [cities, setCities] = useState([{}]);
  useEffect(() => {
    const request = async () => {
      const response = await fetch(`http://13.59.92.254:8080/ciudad`);
      const result = await response.json();
      setCities(result);
    };
    request();
  });
  const [state, setState] = useState([
    {
      startDate: new Date(),
      endDate: null,
      key: "selection",
    },
  ]);
  const [showCalendar, setshowCalendar] = useState(false);
  const updatedCities = [...cities].sort((a, b) => a.id - b.id);
  const handleClick = () => {
    setshowCalendar(false);
  };
  return (
    <SearchContainer>
      <h1>La forma mas facil y segura de rentar tu carro</h1>
      <SearchForm>
        <IconSelect>
          <BsFillPinMapFill className="icon" />
          <SearchSelect required>
            <option value="S">Recogida</option>
            {updatedCities.map((city) => (
              <option key={city.id} value={city.localidad}>
                <Icon icon="akar-icons:twitter-fill" />
                {city.localidad + " , " + city.provincia}
              </option>
            ))}
          </SearchSelect>
        </IconSelect>
        <IconSelect>
          <BsFillPinMapFill className="icon" />
          <SearchSelect required>
          <option value="S">Recogida</option>
            {updatedCities.map((city) => (
              <option key={city.id} value={city.localidad}>
                <Icon icon="akar-icons:twitter-fill" />
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
        <SearchButton type="submit" onClick={() => handleClick}>
          Buscar Carro
        </SearchButton>
      </SearchForm>
    </SearchContainer>
  );
};

export default Searcher;
