import styled from "styled-components";

export const LoginC = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: start;
  flex-grow: 1;
  background: rgba(243, 241, 237, 0.5);
  backdrop-filter: blur(4px);
`;

export const LoginXButton = styled.button`
  background: rgba(255, 255, 255, 0.5);
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-radius: 50%;
  height: 25px;
  width: 25px;
  align-self: flex-end;
  margin-right: 50px;
  margin-top: 50px;
  cursor: pointer;
  @media only screen and (max-width: 800px) {
    margin-top: 20px;
    margin-right: 20px;

  }
`;

export const FormDiv = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background: rgba(255, 255, 255, 0.5);
  border: 2px solid #ffffff;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 10px;
  width: 584px;
  height: 428px;
  margin-top: 100px;
  h2 {
    color: #f0572d;
    font-weight: 700;
    font-size: 24px;
    line-height: 28px;
  }
  @media only screen and (max-width: 800px) {
    margin-top: 20px;
  }
  @media only screen and (max-width: 500px) {
    width: 80vw;
  }
`;

export const FormDiv2 = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background: rgba(255, 255, 255, 0.5);
  border: 2px solid #ffffff;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 10px;
  width: 584px;
  height: 573px;
  margin-top: 40px;
  h2 {
    color: #f0572d;
    font-weight: 700;
    font-size: 24px;
    line-height: 28px;
  }
  @media only screen and (max-width: 800px) {
    margin-top: 20px;
    height: 480px;
    margin-bottom: 20px;
  }
  @media only screen and (max-width: 500px) {
    width: 80vw;
  }
`;

export const UserForm = styled.form`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  width: 30vw;
  label {
    width: 448px;
    margin: 10px;
    @media only screen and (max-width: 800px) {
    width: 70vw;
  }
    input {
      width: 100%;
    }
  }
`;

export const MainButton = styled.button`
  font-weight: 100;
  border: 1px solid #f0572d;
  background-color: #f0572d;
  color: white;
  box-shadow: 0 0 30px rgba(125, 33, 129, 0.4);
  height: 2rem;
  width: 10rem;
  border-radius: 10px;
  margin: 10px;
  cursor: pointer;
`;

export const SecondButton = styled.button`
  font-weight: 500;
  font-size: 16px;
  color: blue;
  border: none;
  text-decoration: underline;
  background: rgba(255, 255, 255, 0.0);
  cursor: pointer;
`;
