package equipo10.integrador_v01.service;

import equipo10.integrador_v01.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    List<Categoria> listarTodasCategorias();

    //read
    Categoria buscarCategoriaXId(Long id);

    //create
    void guardarCategoria(Categoria categoria);

    //delete
    void eliminarCategoria(Long id);

    //update
    void actualizarCategoria(Long id, Categoria categoria);
}