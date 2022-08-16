import styled from "styled-components";

export const ProductContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #ffffff;
`;

export const HeaderContainer = styled.div`
  grid-column: 1;
  grid-row: 1;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr;
  width: 100vw;
  height: 121px;
`;

export const LHeader = styled.div`
  grid-column: 1;
  grid-row: 1;
  margin-left: 65px;
  margin-top: 27px;
  p {
    font-size: 14px;
    font-weight: 700;
    color: #666666;
    line-height: 18px;
    margin: 5px;
  }
  h1 {
    font-size: 24px;
    line-height: 28px;
    font-weight: 700;
    color: #1a1a1a;
    margin: 5px;
  }
  div {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: flex-start;
    gap: 6px;
    margin: 5px;
    p {
      font-size: 14px;
      font-weight: 500;
      color: #1a1a1a;
      line-height: 16px;
    }
  }
`;

export const RHeader = styled.div`
  grid-column: 2;
  grid-row: 1;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  margin-right: 70px;
  margin-top: 27px;
  .arrow {
    width: 20px;
    height: 30px;
  }
`;

export const ImageContainer = styled.div`
  grid-column: 1;
  grid-row: 2;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr;
  width: 90vw;
  height: 400px;
  background: #ffffff;
  border: 1px solid #f3f1ed;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 8px;
  margin-bottom: 60px;
  .MainImg {
    grid-column: 1 / span 2;
    grid-row: 1 / span 2;
    margin-top: 44px;
    margin-left: 51px;
  }
  .SecondImg {
    grid-column: 3;
    grid-row: 1;
  }
  .ThirdImg {
    grid-column: 4;
    grid-row: 1;
  }
  .FourthImg {
    grid-column: 3;
    grid-row: 2;
  }
  .FifthImg {
    grid-column: 4;
    grid-row: 2;
  }
`;

export const DescriptionContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 90vw;
  height: 288px;
  background-color: #f3f1ed;
  h2 {
    font-weight: 700;
    font-size: 24px;
    line-height: 30px;
    color: #1a1a1a;
    margin-top: 56px;
    margin-left: 34px;
  }
  p {
    font-size: 14px;
    font-weight: 500;
    color: #1a1a1a;
    line-height: 16px;
    margin-top: 18px;
    margin-left: 34px;
  }
`;

export const FeaturesContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 90vw;
  height: 288px;
  h2 {
    font-weight: 700;
    font-size: 24px;
    line-height: 28px;
    color: #1a1a1a;
  }
  div {
    width: 90vw;
    height: 288px;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: 1fr 1fr;
  }
`;

export const CalendarContainer = styled.div`
  width: 90vw;
  height: 488px;
  h2 {
    font-weight: 700;
    font-size: 24px;
    line-height: 28px;
    color: #1a1a1a;
  }
`;

export const CalendarSection = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  gap: 100px;
`;

export const CalendarItem = styled.div`
  width: 410px;
  height: 150px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background: #ffffff;
  border: 1px solid #dfe4ea;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 8px;
  h3 {
    font-weight: 700;
    font-size: 16px;
    line-height: 18px;
    color: #1a1a1a;
    width: 90%;
  }
  button {
    background: #f0572d;
    box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.12);
    border-radius: 5px;
    color: #ffffff;
    width: 90%;
    height: 40px;
    border: none;
  }
`;
