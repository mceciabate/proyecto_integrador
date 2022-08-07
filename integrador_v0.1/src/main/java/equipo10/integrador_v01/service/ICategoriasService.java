package equipo10.integrador_v01.service;

import equipo10.integrador_v01.model.Categorias;

import java.util.List;

public interface ICategoriasService {

    List<Categorias> listarTodasCategorias();

    //read
    Categorias buscarCategoriaXId(Long id);

    //create
    void guardarCategoria(Categorias categoria);

    //delete
    void eliminarCategoria(Long id);

    //update
    void actualizarCategoria(Categorias categoria);
}