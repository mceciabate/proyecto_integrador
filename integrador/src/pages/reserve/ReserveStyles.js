import styled from "styled-components";

export const ReserveContainer = styled.div`
  width: 100%;
  height: 100%;
  background: #f3f1ed;
`;

export const HeaderContainer = styled.div`
  grid-column: 1;
  grid-row: 1;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr;
  width: 100vw;
  height: 100px;
  max-height: fit-content;
  background: white;
`;

export const LHeader = styled.div`
  margin-left: 40px;
  grid-column: 1;
  grid-row: 1;
  margin-top: 27px;
  @media (max-width: 800px) {
    margin-left: 34px;
    margin-top: 15px;
  }
  @media (max-width: 500px) {
    margin-left: 24px;
  }
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
`;

export const RHeader = styled.div`
  grid-column: 2;
  grid-row: 1;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  margin-top: 27px;
  margin-right: 40px;
  @media (max-width: 800px) {
    margin-right: 34px;
    margin-top: 15px;
  }
  @media (max-width: 500px) {
    margin-right: 24px;
  }
  .arrow {
    width: 20px;
    height: 30px;
  }
`;

export const BodyContainer = styled.div`
  display: grid;
  grid-template-columns: 1fr 0.7fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  width: 100vw;
  column-gap: 29px;
  margin: 50px 0px 50px 0px;
`;
export const FormContainer = styled.div`
  grid-column: 1 / span 2;
  grid-row: 1;
  display: flex;
  flex-direction: column;
  margin-left: 70px;

  h2 {
    font-weight: 700;
    font-size: 20px;
    line-height: 25px;
  }
  form{
  background: #ffffff;
  border: 1px solid #dfe4ea;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 8px;
  min-height:  220px ;
  width: 800px;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr ;
  padding-top:30px;
  padding-bottom:-40px;
    label {
      height: 100px;
      width: 90%;
      display: flex;
      flex-direction: column;
      font-weight: 500;
      size: 12px;
      justify-content: center;
      justify-self: center;
      margin-top: -20px;
      input {
        height: 40px;
        width: 100%;
        background: #f3f1ed;
        opacity: 0.4;
        box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.15);
        border-radius: 5px;
        border: none;
      }
      select {
        height: 40px;
        width: 100%;
        background: #f3f1ed;
        opacity: 0.4;
        box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.15);
        border-radius: 5px;
        border: none;
      }
    }
  }
`; 
export const FormContainer2 = styled.div`
  grid-column: 1 / span 2;
  grid-row: 1;
  display: flex;
  flex-direction: column;
  margin-left: 70px;

  h2 {
    font-weight: 700;
    font-size: 20px;
    line-height: 25px;
  }
  form{
  background: #ffffff;
  border: 1px solid #dfe4ea;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 8px;
  min-height:  220px ;
  width: 800px;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr ;
  h4 {
    font-size: 15px;
    font-weight: bold;
    width: 100%;
    padding: 10px 10px 10px 10px;
    margin:10px;
  }
    label {
      height: 100px;
      width: 90%;
      display: flex;
      flex-direction: column;
      font-weight: 500;
      size: 12px;
      justify-content: center;
      justify-self: center;
      margin-top: -20px;
      input {
        height: 40px;
        width: 100%;
        background: #f3f1ed;
        opacity: 0.4;
        box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.15);
        border-radius: 5px;
        border: none;
      }
      select {
        height: 40px;
        width: 100%;
        background: #f3f1ed;
        opacity: 0.4;
        box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.15);
        border-radius: 5px;
        border: none;
      }
    }
  }
`; 

export const CalendarContainer = styled.div`
  height: 370px;
  width: 800px;
  grid-column: 1 / span 2;
  grid-row: 2;
  display: flex;
  flex-direction: column;
  margin-left: 70px;
  margin-top:-20px;
  h2 {
    font-size: 20px;
    font-weight: 700;
    line-height: 25px;
  }
`;

export const Schedule = styled.div`
  display: flex;
  flex-direction: column;
  grid-column: 1 / span 2;
  grid-row: 3;
  h2 {
    margin-left: 70px;
    font-size: 20px;
    font-weight: 700;
    line-height: 25px;
  }
`;
export const MainButton = styled.button`
  font-weight: 100px;
  font-size: 15px;
  border: 1px solid #f0572d;
  background-color: #f0572d;
  color: white;
  box-shadow: 0 0 30px rgba(125, 33, 129, 0.4);
  height: 3rem;
  width: 15rem;
  border-radius: 10px;
  margin-left: 95px;
  margin-bottom: 10px;
  cursor: pointer;
`;

export const Detail = styled.div`
  grid-column: 3;
  grid-row: 1 / span 3;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  background: #ffffff;
  border: 1px solid #dfe4ea;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 8px;
  height: 945px;
  width: 420px;
  margin-top: 55px;
  h2{
    margin: 5px;
  }
  .htop {
    margin-left: 21px;
    font-size: 24px;
    font-weight: 700;
    line-height: 28px;
  }
  img {
    height: 322px;
    padding: 0px;
  }
  div {
    margin-left: 21px;
    .pcategory {
      font-weight: 700;
      font-size: 14px;
      line-height: 18px;
      color: #1a1a1a;
      opacity: 0.5;
    }
    .hbottom {
      font-weight: 700;
      font-size: 24px;
      line-height: 28px;
      color: #1a1a1a;

    }
    .plocation {
      font-weight: 500;
      font-size: 14px;
      line-height: 16px;
      color: #1a1a1a;
    }
  }
`;
