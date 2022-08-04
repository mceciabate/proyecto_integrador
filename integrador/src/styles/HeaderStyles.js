import styled from "styled-components";

export const HeaderC = styled.header`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  height: 8vh;
  background-color: white;
`;

export const SectionC = styled.section`
  margin: 10px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 25px;
  .lema {
    text-decoration: none;
    color: #F0572D;
  }
`;

export const HeaderButton = styled.button`
  font-weight: 100;
  border: 1px solid #F0572D;
  background-color: #F0572D;
  color: white;
  box-shadow: 0 0 30px rgba(125, 33, 129, 0.4);
  height: 2rem;
  width: 10rem;
  border-radius: 10px;
`;