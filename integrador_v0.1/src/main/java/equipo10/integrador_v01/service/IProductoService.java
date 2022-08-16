package equipo10.integrador_v01.service;

import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.CategoriaDTO;
import equipo10.integrador_v01.model.entity.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> listarProductos();

    //read
    Producto buscarProductosPorId(Long id);

    //create
    Producto guardarProductos(Producto producto);

    //delete
    void eliminarProductos(Long id) throws ResourceNotFoundException;

    //update
    void actualizarProductos(Producto producto) throws ResourceNotFoundException;
}
