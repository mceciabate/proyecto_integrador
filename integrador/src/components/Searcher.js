import React from "react";
import { useState, useEffect } from "react";
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
  const [products, setProducts] = useState();
  useEffect(() => {
    const request = async () => {
      const response = await fetch(`http://18.219.33.103:8080/products`);
      const result = await response.json();
      setProducts(result);
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
  const array = [];
  return (
    <SearchContainer>
      <h1>La forma mas facil y segura de rentar tu carro</h1>
      <SearchForm>
        <IconSelect>
          <BsFillPinMapFill className="icon" />
          <SearchSelect required>
            <option value="S">Recogida</option>
            {products &&
              products.map((product, index) => (
                <option key={index} value={product.city.value}>
                  {product.city.name}
                </option>
              ))}
          </SearchSelect>
        </IconSelect>
        <IconSelect>
          <BsFillPinMapFill className="icon" />
          <SearchSelect required>
            <option value="S">Entrega</option>
            {products &&
              products.map((product) => {
                return (
                <option key={product.city.id} value={product.city.value}>
                  <Icon icon="akar-icons:twitter-fill" />
                  {product.city.name}
                </option>
                )
              })}
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
