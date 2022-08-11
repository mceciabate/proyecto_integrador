import styled from "styled-components";

export const SearchContainer = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  height: 92vh;
  h1 {
    font-weight: 700;
    font-size: 40px;
    line-height: 50px;
    grid-column: 2 / 4;
    grid-row: 2 / 4;
    width: 336px;
    padding: 10px;
    text-align: center;
    @media only screen and (max-width: 770px) {
      grid-row: 1 / 4;
  }
  }
`;

export const SearchForm = styled.form`
  grid-column: 2 / 4;
  grid-row: 3 / 4;
  width: 80vw;
  background-color: #FFF;
  height: 151px;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  gap: 35px;
  border-radius: 10px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border: 1px solid #dfe4ea;
  @media only screen and (max-width: 770px) {
    height: 110px;
    width: 90vw;
  }
  @media only screen and (max-width: 480px) {
    height: max-content;
    flex-direction: column;
    gap: 5px;

  }
`;

export const SearchSelect = styled.select`
  width: 30%;
  height: 2rem;
  margin: 10px 0px 10px;
  @media only screen and (max-width: 770px) {
    width: 60px;
  }
  @media only screen and (max-width: 480px) {
    width: 90%;
  }
`;

export const SearchButton = styled.button`
  font-weight: 400;
  border: none;
  background-color: #F0572D;
  color: white;
  border-radius: 25px;
  box-shadow: 0 0 30px rgba(125, 33, 129, 0.4);
  height: 1.5rem;
  width: 30%;
  min-width: 100px;
  margin: 10px 0px 10px;
  margin-right: 32px;
  cursor: pointer;
  @media only screen and (max-width: 480px) {
    width: 90%;
    margin: 10px;
  }

`;

export const CalendarDiv = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  margin-left: 32px;
  @media only screen and (max-width: 480px) {
    margin-left: 0;
    width: 50vw;
    align-self: center;
    align-items: center;
  }
  `
