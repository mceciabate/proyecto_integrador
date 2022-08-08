import styled from "styled-components";

export const LoginC = styled.div`
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  background-color: #C4C4C4;

`

export const LoginXButton = styled.button`
  background-color: #fff;
  border: 1px solid #000;
  height: 25px;
  width: 25px;
  align-self: flex-end;
`

export const FormDiv = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  h2{
    color: #F0572D;
    font-weight: 700;
    font-size: 24px;
  }
`

export const UserForm = styled.form`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  width: 30vw;
  label{
    width: 100%;
    margin: 10px;
    input{
      width: 100%;
    }  
  }
`

export const MainButton = styled.button`
  font-weight: 100;
  border: 1px solid #F0572D;
  background-color: #F0572D;
  color: white;
  box-shadow: 0 0 30px rgba(125, 33, 129, 0.4);
  height: 2rem;
  width: 10rem;
  border-radius: 10px;
  margin: 10px;
`

export const SecondButton = styled.button`
  font-weight: 500;
  font-size: 16px;
  color: blue;
  border: none;
  text-decoration: underline;
  background-color: #C4C4C4;
`