import React, { useState } from "react";
import {
  FormDiv2,
  UserForm,
  MainButton,
  SecondButton,
  StyledInlineErrorMessage,
} from "./LoginStyles";
import { Formik, Field } from "formik";
import * as Yup from "yup";

const RegisterForm = ({ handleView }) => {
  const [formValues, setFormValues] = useState({});
  return (
    <FormDiv2>
      <h2>Crea tu cuenta</h2>
      <Formik
        initialValues={{
          nombre: "",
          apellido: "",
          email: "",
          contrasenia: "",
          rol: { id: 1, nombre: "Usuario" },
        }}
        validationSchema={Yup.object().shape({
          nombre: Yup.string()
            .min(2, "Tu nombre es muy corto")
            .required("Porfavor ingrese su nombre"),
          apellido: Yup.string()
            .min(2, "Tu apellido es muy corto")
            .required("Por favor ingrese su apellido"),
          email: Yup.string()
            .email("The email is incorrect")
            .required("Please enter your email"),
          contrasenia: Yup.string()
            .min(4, "Tu contrasenia es muy corta (min 4)")
            .required("Porfavor ingrese una contrasenia"),
          confirmContra: Yup.string().oneOf(
            [Yup.ref("contrasenia"), null],
            "Las contrasenias deben coincidir"
          ),
        })}
        onSubmit={async({ nombre, apellido, email, contrasenia }, actions) => {
          setFormValues({
            nombre: nombre,
            apellido: apellido,
            email: email,
            contrasenia: contrasenia,
            rol: { id: 1, nombre: "USUARIO" },
          });
          if(formValues) {
          await fetch("http://18.223.117.95:8080/usuario/guardar", {
            method: "POST",
            mode: 'no-cors',
            headers: 'Access-Control-Allow-Origin',
            body: JSON.stringify(formValues),
          })
          const timeOut = setTimeout(() => {
            actions.setSubmitting(false);
            clearTimeout(timeOut);
          }, 1000);
        } else console.log("error para registrar usuario")
        }}
      >
        {({
          values,
          errors,
          touched,
          handleSubmit,
          isSubmitting,
          validating,
          valid,
        }) => {
          return (
            <>
              <UserForm method="post" onSubmit={handleSubmit}>
                <label>
                  Nombre:
                  <Field name="nombre" type="text" />
                </label>
                {errors.nombre && touched.nombre && (
                  <StyledInlineErrorMessage>
                    {errors.nombre}
                  </StyledInlineErrorMessage>
                )}
                <label>
                  Apellido
                  <Field name="apellido" type="text" />
                </label>
                {errors.apellido && touched.apellido && (
                  <StyledInlineErrorMessage>
                    {errors.apellido}
                  </StyledInlineErrorMessage>
                )}
                <label>
                  Email:
                  <Field name="email" type="email" />
                </label>
                {errors.email && touched.email && (
                  <StyledInlineErrorMessage>
                    {errors.email}
                  </StyledInlineErrorMessage>
                )}
                <label>
                  Contraseña:
                  <Field name="contrasenia" type="password" />
                </label>
                {errors.contrasenia && touched.contrasenia && (
                  <StyledInlineErrorMessage>
                    {errors.contrasenia}
                  </StyledInlineErrorMessage>
                )}
                <label>
                  Confirmar Contraseña:
                  <Field name="confirmContra" type="password" />
                </label>
                {errors.confirmContra && touched.confirmContra && (
                  <StyledInlineErrorMessage>
                    {errors.confirmContra}
                  </StyledInlineErrorMessage>
                )}
                <MainButton type="submit">Crear cuenta</MainButton>
              </UserForm>
            </>
          );
        }}
      </Formik>
      <p>
        Ya tienes una cuenta?{" "}
        <SecondButton onClick={() => handleView("login")}>
          Inicia Sesion
        </SecondButton>{" "}
      </p>
    </FormDiv2>
  );
};

export default RegisterForm;
