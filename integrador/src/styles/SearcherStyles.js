import styled from "styled-components";

export const SearchContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  h1 {
    margin: 5px;
  }
  p {
    margin: 5px;
  }
`;

export const SearchForm = styled.form`
  width: 80vw;
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  justify-content: center;
  gap: 35px;
`;

export const SearchSelect = styled.select`
  width: 30%;
  height: 2rem;
  margin: 10px 0px 10px;
`;

export const SearchButton = styled.button`
  font-weight: 400;
  border: none;
  color: #F0572D;
  border-radius: 25px;
  box-shadow: 0 0 30px rgba(125, 33, 129, 0.4);
  height: 1.5rem;
  width: 30%;
  min-width: 100px;
  margin: 10px 0px 10px;
`;

export const CalendarDiv = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-end;
`
