import React from "react";
import { useState } from "react";
import { cities } from "../data/cities";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import {
  SearchContainer,
  SearchForm,
  SearchSelect,
  SearchButton,
  CalendarDiv,
} from "../styles/SearcherStyles";

const Searcher = () => {
  const [startDate, setsstartDate] = useState(new Date());
  const [finishDate, setfinishDate] = useState(new Date());
  const [showCalendar, setshowCalendar] = useState(false);
  return (
    <SearchContainer>
      <h1>Searcher</h1>
      <p>Please pick you first and last day, and then choose your city</p>
      <SearchForm>
        <SearchButton onClick={() => setshowCalendar(true)}>
          Pick dates
        </SearchButton>
        {showCalendar ? (
          <CalendarDiv>
            <Calendar onChange={setsstartDate} value={startDate} required />
            <Calendar onChange={setfinishDate} value={finishDate} required />
          </CalendarDiv>
        ) : null}
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
