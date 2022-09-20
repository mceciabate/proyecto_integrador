import React, { useEffect } from "react";
import {
  AdminContainer,
  HeaderContainer,
  StyledH2,
  StyledForm,
  StyledInput,
  TitleDesc,
  CatCity,
  Feature,
  Images,
  StyledButton,
  DivButton,
} from "./AdminProductStyles";
import { useState } from "react";

const AdminProduct = () => {
  const [title, setTitle] = useState();
  const [description, setDescription] = useState();
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState({ obj: null });
  useEffect(() => {
    const request = async () => {
      const response = await fetch(
        `http://18.223.117.95:8080/categoria/listar`
      );
      const result = await response.json();
      setCategories(result);
    };
    request();
  }, []);
  const handleCategory = (e) => {
    setSelectedCategory({ obj: categories[e.target.value] });
  };

  const [image, setImage] = useState({
    title: "",
    url: "",
  });
  const handleChange = (e) => {
    const { name, value } = e.target;
    setImage((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const [selectedCity, setSelectedCity] = useState({ obj: null });
  const [cities, setCities] = useState([{}]);
  useEffect(() => {
    const request = async () => {
      const response = await fetch(`http://18.223.117.95:8080/ciudad`);
      const result = await response.json();
      setCities(result);
    };
    request();
  }, []);
  const handleCity = (e) => {
    setSelectedCity({ obj: cities[e.target.value] });
  };

  const [feature, setFeature] = useState({
    nombre: "",
    valor: "",
    url: "",
  });
  const handleFeature = (e) => {
    const { name, value } = e.target;
    setFeature((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };
  const [feature1, setFeature1] = useState({
    nombre: "",
    valor: "",
    url: "",
  });
  const handleFeature1 = (e) => {
    const { name, value } = e.target;
    setFeature1((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };
  const [feature2, setFeature2] = useState({
    nombre: "",
    valor: "",
    url: "",
  });
  const handleFeature2 = (e) => {
    const { name, value } = e.target;
    setFeature2((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    fetch("http://18.223.117.95:8080/producto/guardar", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: "Bearer " + window.localStorage.getItem("Token"),
      },
      body: JSON.stringify({
        titulo: title,
        descripcion: description,
        imagen: [
          {
            id: 65,
            titulo: image.title,
            urlImg: image.url,
          },
          {
            id: 37,
            titulo: "zInteriorDeportivo1",
            urlImg:
              "https://ubicarbd.s3.us-east-2.amazonaws.com/imagenesCarros/deportivos/zInteriorDeportivo1.png",
          },
          {
            id: 38,
            titulo: "zInteriorDeportivo2",
            urlImg:
              "https://ubicarbd.s3.us-east-2.amazonaws.com/imagenesCarros/deportivos/zInteriorDeportivo2.png",
          },
          {
            id: 39,
            titulo: "zInteriorDeportivo3",
            urlImg:
              "https://ubicarbd.s3.us-east-2.amazonaws.com/imagenesCarros/deportivos/zInteriorDeportivo3.png",
          },
          {
            id: 40,
            titulo: "zInteriorDeportivo4",
            urlImg:
              "https://ubicarbd.s3.us-east-2.amazonaws.com/imagenesCarros/deportivos/zInteriorDeportivo4.png",
          },
        ],
        caracteristica: [
          {
            id: 17,
            nombre: "Bolsas de Aire",
            icono:
              "https://ubicarbd.s3.us-east-2.amazonaws.com/icon/cloud-fog2.svg",
            valor: "6",
          },
          {
            id: 18,
            nombre: "Bloqueo central",
            icono: "https://ubicarbd.s3.us-east-2.amazonaws.com/icon/lock.svg",
            valor: "Sí",
          },
          {
            id: 20,
            nombre: "Bluetooth",
            icono:
              "https://ubicarbd.s3.us-east-2.amazonaws.com/icon/bluetooth.svg",
            valor: "Sí",
          },
        ],
        politica: [],
        ciudad: selectedCity.obj,
        categoria: selectedCategory.obj,
      }),
    }).then((response) => {
      if (response.status < 300) {
        alert("success");
      } else {
        alert(`Error con respuesta: ${response.status}`);
      }
    });
  };
  console.log(
    title,
    description,
    selectedCategory.obj,
    selectedCity.obj,
    image,
    feature,
    feature1,
    feature2
  );
  return (
    <AdminContainer>
      <HeaderContainer>
        <h1>Administracion</h1>
      </HeaderContainer>
      <StyledH2>Crear Producto</StyledH2>
      <StyledForm onSubmit={handleSubmit}>
        <TitleDesc>
          <label>
            Titulo:
            <StyledInput
              required
              type="text"
              placeholder="titulo del auto"
              name="title"
              value={title}
              onChange={(event) => setTitle(event.target.value)}
            />
          </label>
          <label>
            Descripcion:
            <StyledInput
              required
              type="text"
              placeholder="descripcion del auto"
              name="description"
              value={description}
              onChange={(event) => setDescription(event.target.value)}
            />
          </label>
        </TitleDesc>
        <CatCity>
          <label>
            Categoria
            <select onChange={handleCategory} required>
              <option value="s">Categorias</option>
              {categories.map((Feature, index) => (
                <option key={index} value={index}>
                  {Feature.titulo + " , " + Feature.descripcion + "."}
                </option>
              ))}
            </select>
          </label>
          <label>
            Ciudad
            <select onChange={handleCity} required>
              <option value="s">Ciudades</option>
              {cities.map((city, index) => (
                <option key={index} value={index}>
                  {city.direccion + " , " + city.provincia}
                </option>
              ))}
            </select>
          </label>
        </CatCity>
        <h4>Imagen</h4>
        <Images>
          <label>
            Titulo:
            <StyledInput
              required
              type="text"
              placeholder="titulo de la imagen"
              name="title"
              value={image.title}
              onChange={handleChange}
            />
          </label>
          <label>
            Imagen (URL):
            <StyledInput
              required
              type="text"
              placeholder="url de la imagen"
              name="url"
              value={image.url}
              onChange={handleChange}
            />
          </label>
        </Images>
        <div>
          <h4>Caracteristicas</h4>
          <Feature>
            <label>
              Nombre:
              <StyledInput
                required
                type="text"
                placeholder="nombre de la caracteristica"
                name="nombre"
                value={feature.nombre}
                onChange={handleFeature}
              />
            </label>
            <label>
              Valor:
              <StyledInput
                required
                type="text"
                placeholder="valor de la caracteristica"
                name="valor"
                value={feature.valor}
                onChange={handleFeature}
              />
            </label>
            <label>
              Icono (URL):
              <StyledInput
                required
                type="text"
                placeholder="icono de la caracteristica"
                name="url"
                value={feature.url}
                onChange={handleFeature}
              />
            </label>
          </Feature>
          <Feature>
            <label>
              Nombre:
              <StyledInput
                required
                type="text"
                placeholder="nombre de la caracteristica"
                name="nombre"
                value={feature1.nombre}
                onChange={handleFeature1}
              />
            </label>
            <label>
              Valor:
              <StyledInput
                required
                type="text"
                placeholder="valor de la caracteristica"
                name="valor"
                value={feature1.valor}
                onChange={handleFeature1}
              />
            </label>
            <label>
              Icono (URL):
              <StyledInput
                required
                type="text"
                placeholder="icono de la caracteristica"
                name="url"
                value={feature1.url}
                onChange={handleFeature1}
              />
            </label>
          </Feature>
          <Feature>
            <label>
              Nombre:
              <StyledInput
                required
                type="text"
                placeholder="nombre de la caracteristica"
                name="nombre"
                value={feature2.nombre}
                onChange={handleFeature2}
              />
            </label>
            <label>
              Valor:
              <StyledInput
                required
                type="text"
                placeholder="valor de la caracteristica"
                name="valor"
                value={feature2.valor}
                onChange={handleFeature2}
              />
            </label>
            <label>
              Icono (URL):
              <StyledInput
                required
                type="text"
                placeholder="icono de la caracteristica"
                name="url"
                value={feature2.url}
                onChange={handleFeature2}
              />
            </label>
          </Feature>
        </div>
        <DivButton>
          <StyledButton type="submit">Crear Producto</StyledButton>
        </DivButton>
      </StyledForm>
    </AdminContainer>
  );
};

export default AdminProduct;
