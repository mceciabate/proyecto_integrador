import styled from "styled-components";

export const ListDiv = styled.div`
  display: flex;
  flex-direction: column;
  background: #F5F4F1;
`;

export const ListC = styled.div`
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
  margin: 10px;
`;

export const ListH3 = styled.h3`
  font-size: 24px;
  font-weight: 700;
  line-height: 28px;
  margin: 20px;
  color: #191b1d;
`

export const CardC = styled.div`
  display: flex;
  width: 635px;
  height: 283px;
  margin: 10px;
  background-color: white;
`;

export const StyledImg = styled.img`
  width: 315px;
  height: 283px;
`;

export const CardDiv = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: space-around;
  width: 300px;
  height: 283px;
  margin-left: 20px;
  h3 {
    font-size: 24px;
    margin: 2px;
    margin: 0;
  }
`;

export const StyledP1 = styled.p`
  font-size: 14px;
  line-height: 18px;
  margin: 2px;
  margin: 3px;
  color: #191b1d;
  opacity: 0.5;
`;

export const StyledP2 = styled.p`
  font-size: 14px;
  line-height: 16px;
  font-weight: 500;
  margin: 1px;
  color: #191b1d;
`;

export const StyledButton = styled.button`
  background-color: #f0572d;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.12);
  border-radius: 10px;
  width: 296px;
  height: 40px;
  border: none;
  cursor: pointer;
`;
