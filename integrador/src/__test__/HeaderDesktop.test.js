import { HeaderC, SectionC, HeaderButton, Logo } from "../styles/HeaderDStyles";
import "@testing-library/jest-dom";
import { cleanup, render, screen } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import Header from '../components/HeaderDesktop'


afterEach(cleanup);

// Happy path: desde el header hacemos click en el logo del header y nos lleva al home
test("Al hacer click en Iniciar Sesión redirecciona al formulario", () => {
    render(<HeaderButton/>);
    const textoInicioSesion = screen.queryByText("Iniciar sesion");
            expect(textoInicioSesion).toBeInTheDocument();
  });

  test("Al hacer click en Crear Cuenta redirecciona al formulario", () => {
    Header();
  let botonCrearCuenta = screen.getByRole("button", {
    name: /Crear cuenta/i,
  });
    expect(botonCrearCuenta).toBeInTheDocument();
    userEvent.click(botonCrearCuenta);
    expect(screen.getByText("Registrate")).toBeInTheDocument();

  });


//   import { cleanup, render, screen } from "@testing-library/react";
// import React from "react";
// import  {CardContainer}  from "../styles/CategoriesStyles";



// afterEach(cleanup);

// describe('Card', () =>{
//     test('renders appropriately',  () =>{
//         render(<CardContainer></CardContainer>);
//         const cat = screen.findAllByTestId("card");
//        expect(cat).toBeInTheDocument();
//     })
// })