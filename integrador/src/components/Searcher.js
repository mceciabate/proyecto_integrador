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
      <h1>Car finder</h1>
      <p>Please pick you first and last day, and then choose your city</p>
      <SearchForm>
          <CalendarDiv>
            <SearchButton onClick={() => setshowCalendar(true)}>
              Pick dates
            </SearchButton>
            {showCalendar ? 
            <DateRange
              editableDateInputs={true}
              onChange={(item) => setState([item.selection])}
              moveRangeOnFirstSelection={false}
              ranges={state}
              rangeColors={["#F0572D"]}
            /> : null }
          </CalendarDiv>
        <SearchSelect required>
          <option value="">Select a city</option>
          {cities.map((city) => (
            <option key={city.id} value={city.value}>
              {city.name}
            </option>
          ))}
        </SearchSelect>
        <SearchButton type="submit" onClick={() => setshowCalendar(false)}>
          Search
        </SearchButton>
      </SearchForm>
    </SearchContainer>
  );
};

export default Searcher;
