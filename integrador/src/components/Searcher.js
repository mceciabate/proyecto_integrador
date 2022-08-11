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
} from "../styles/SearcherStyles";
import { DateRange } from "react-date-range";
import "react-date-range/dist/styles.css";
import "react-date-range/dist/theme/default.css";

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
        <CalendarDiv>
          {showCalendar ? (
            <DateRange
              editableDateInputs={true}
              onChange={(item) => setState([item.selection])}
              moveRangeOnFirstSelection={false}
              ranges={state}
              rangeColors={["#F0572D"]}
            />
          ) : (
            <SearchButton onClick={() => setshowCalendar(true)}>
              Pick dates
            </SearchButton>
          )}
        </CalendarDiv>
        <SearchSelect required>
          <option value="S">Lugar de entrega</option>
          {cities.map((city) => (
            <option key={city.id} value={city.value}>
              {city.name}
            </option>
          ))}
        </SearchSelect>
        <SearchSelect required>
          <option value="S">Lugar de recogida</option>
          {cities.map((city) => (
            <option key={city.id} value={city.value}>
              {city.name}
            </option>
          ))}
        </SearchSelect>
        <CalendarDiv>
          <SearchButton type="submit" onClick={() => setshowCalendar(false)}>
            Buscar Carro
          </SearchButton>
        </CalendarDiv>
      </SearchForm>
    </SearchContainer>
  );
};

export default Searcher;
