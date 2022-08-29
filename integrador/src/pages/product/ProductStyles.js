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
  height: 140px;
  max-height: fit-content;
`;

export const LHeader = styled.div`
  grid-column: 1;
  grid-row: 1;
  margin-left: 65px;
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

export const ImageContainer = styled.div`
  grid-column: 1;
  grid-row: 2;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr;
  width: 90vw;
  height: auto;
  max-height: 500px;
  background: transparent;
  margin-bottom: 60px;
  gap: 5px;
  .main-image {
    grid-column: 1 / span 2;
    grid-row: 1 / span 2;
    display: flex;
    align-items: center;
    background: #ffffff;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 8px;
    max-height: 500px;
    justify-content: center;
    img {
      border-radius: 8px;
      width: 100%;
      height: 100%;
      max-height: 500px;
      max-width: max-content;
    }
    @media (max-width: 500px) {
      grid-column: 1 / span 4;
    }
  }
  .image {
    width: auto;
    height: auto;
    display: flex;
    align-items: center;
    background: #ffffff;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 8px;
    justify-content: center;
    img {
      border-radius: 8px;
      width: 100%;
      height: 100%;
      max-height: 197.5px;
      max-width: max-content;
    }
    @media (max-width: 800px) {
      
    }
    @media (max-width: 500px) {
      display: none;
    }
  }
`;

export const DescriptionContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 90vw;
  height: 288px;
  background-color: #f3f1ed;
  @media (max-width: 500px) {
    height: 380px;
  }
  h2 {
    font-weight: 700;
    font-size: 24px;
    line-height: 30px;
    color: #1a1a1a;
    margin-top: 56px;
    margin-left: 34px;
    @media (max-width: 800px) {
      margin-top: 40px;
      margin-left: 28px;
    }
    @media (max-width: 500px) {
      margin-top: 24px;
      margin-left: 24px;
    }
  }
  p {
    font-size: 14px;
    font-weight: 500;
    color: #1a1a1a;
    line-height: 16px;
    margin-top: 18px;
    margin-left: 34px;
    @media (max-width: 500px) {
      margin-top: 24px;
      margin-left: 24px;
    }
  }
`;

export const FeaturesContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 90vw;
  height: 288px;
  @media (max-width: 800px) {
    height: 330px;
  }
  @media (max-width: 500px) {
      height: 400px;    
  }
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
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-rows: 1fr 1fr;
    @media (max-width: 800px) {
      grid-template-columns: 1fr 1fr;
    }
    @media (max-width: 500px) {
      grid-template-columns: 1fr;
      margin-left: 20px;
    }
  }
`;

export const MyH2 = styled.h2`
    text-align: start;
    width: 90vw;
    font-weight: 700;
    font-size: 24px;
    line-height: 28px;
    color: #1a1a1a;
    height: fit-content;
    @media (max-width: 500px) {
      margin-left: 20px;
    }
`

export const CalendarContainer = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr;
  width: 90vw;
  height: 488px;
  column-gap: 3vw;
  @media (max-width: 800px) {
    height: 500px;
    grid-template-columns: 1fr 1fr;
  }
`;

export const CalendarSection = styled.div`
  margin-top: 4vh;
  grid-column: 3;
  display: flex;
  flex-direction: column;
  align-items: center;
  @media (max-width: 800px) {
    grid-column: 1/ span 2;
    grid-row: 2;
  }
`;

export const CalendarItem = styled.div`
  width: 370px;
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

export const FooterContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 90vw;
  @media (max-width: 800px) {
      align-items: center;
    }
  h2 {
    font-weight: 700;
    font-size: 24px;
    line-height: 28px;
    color: #1a1a1a;
    margin-top: 25px;
  }
`;
export const FooterItemContainer = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  @media (max-width: 800px) {
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 1fr 1fr;
  }
  @media (max-width: 500px) {
    grid-template-columns: 1fr;
    grid-template-rows: 1fr 1fr 1fr;
  }
  width: 100%;
`;

export const FooterItem = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 25px;
  margin: 0 5vw 0 5vw;
  h4 {
    font-weight: 700;
    font-size: 20px;
    line-height: 24px;
    color: #1a1a1a;
  }
  p {
    font-size: 14px;
    font-weight: 500;
    color: #1a1a1a;
    line-height: 16px;
  }
`;

export const GalleryContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background: rgba(243, 241, 237, 0.5);
  backdrop-filter: blur(4px);
  width: 100vw;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 1000;
`;

export const GalleryItem = styled.div`
  display: flex;
  flex-direction: column;
  width: 638px;
  height: 476px;
  background: rgba(255, 255, 255, 0.5);
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 8px;
  @media (max-width: 500px) {
    width: 100%;
    height: 100%;
  }
`;

export const MainImageContainer = styled.div`
  position: relative;
  width: 100%;
  height: auto;
  max-height: 323px;
  border-radius: 8px;
  display: flex;
  justify-content: center;
`;

export const MainImage = styled.img`
  width: auto;
  height: auto;
  max-height: 350px;
  border-radius: 8px 8px 0 0;
`;

export const GalleryButton = styled.button`
  color: #191b1d;
  background: none;
  border: none;
  cursor: pointer;
  font-size: 24px;
  font-weight: 500;
  line-height: 28px;
  position: absolute;
  right: 0;
`;

export const ArrowButton = styled.button`
  align-self: center;
  font-weight: 700;
  font-size: 24px;
  height: 35px;
  width: 35px;
  background: #f3f1ed;
  opacity: 0.5;
  border: 0.5px solid #ffffff;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 25px;
  cursor: pointer;
  position: absolute;
  right: 0;
  bottom: 40%;
`;

export const MyP = styled.p`
  font-size: 16px;
  margin: 0;
  font-weight: 700;
  text-align: center;
  margin-top: 3px;
`;

export const Carrousel = styled.div`
  height: 130px;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr;
  @media (max-width: 500px) {
    grid-template-columns: 1fr 1fr;
    height: auto;
  }
`;

export const CarrouselImg = styled.img`
  align-self: center;
  justify-self: center;
  max-width: 148px;
  max-height: 91px;
  border-radius: 8px;
  @media (max-width: 500px) {
    height: auto;
    margin-bottom: 15px;
  }
`;
