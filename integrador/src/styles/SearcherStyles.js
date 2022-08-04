import styled from "styled-components";

export const SearchContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

export const SearchForm = styled.form`
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
`;

export const SearchSelect = styled.select`
  width: 100%;
  height: 2rem;
  margin: 10px 0px 10px;
`;

export const SearchButton = styled.button`
  font-weight: 100;
  border: none;
  border-radius: 25px;
  box-shadow: 0 0 30px rgba(125, 33, 129, 0.4);
  height: 1.5rem;
  width: 10rem;
  margin: 10px 0px 10px;
`;

export const CalendarDiv = styled.div`
  display: flex;
`
