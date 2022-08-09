package equipo10.integrador_v01.service;

import equipo10.integrador_v01.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    List<Categoria> listarCategoria();

    //read
    Categoria buscarCategoriaPorId(Long id);

    //create
    Categoria guardarCategoria(Categoria categoria);

    //delete
    void eliminarCategoria(Long id);

    //update
    Categoria actualizarCategoria(Long id, Categoria categoria);
}