import React from "react";
import { useState } from "react";
import cities from "../data/cities";
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
  const [state, setState] = useState([
    {
      startDate: new Date(),
      endDate: null,
      key: "selection",
    },
  ]);
  const [showCalendar, setshowCalendar] = useState(false);
  return (
    <SearchContainer>
      <h1>La forma mas facil y segura de rentar tu carro</h1>
      <SearchForm>
        <IconSelect>
      <BsFillPinMapFill className="icon"/>
        <SearchSelect required>
          <option value="S">
            Recogida
          </option>
          {cities.map((city) => (
            <option key={city.id} value={city.value}>
                {city.name}
            </option>
          ))}
        </SearchSelect>
        </IconSelect>
        <IconSelect>
        <BsFillPinMapFill className="icon" />
        <SearchSelect required>
          <option value="S">Entrega</option>
          {cities.map((city) => (
            <option key={city.id} value={city.value}>
              <Icon icon="akar-icons:twitter-fill" />
              {city.name}
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
        <SearchButton type="submit" onClick={() => setshowCalendar(false)}>
          Buscar Carro
        </SearchButton>
      </SearchForm>
    </SearchContainer>
  );
};

export default Searcher;
