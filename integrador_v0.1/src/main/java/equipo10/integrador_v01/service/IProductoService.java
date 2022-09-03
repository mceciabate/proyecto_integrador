package equipo10.integrador_v01.service;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ProductoDTO;

import java.time.LocalDate;
import java.util.List;

public interface IProductoService {
    List<ProductoDTO> listarProductos();

    //read
    ProductoDTO buscarProductosPorId(Long id);

    //create
    ProductoDTO guardarProductos(ProductoDTO productoDTO) throws BadRequestException;

    //delete
    void eliminarProductos(Long id) throws ResourceNotFoundException;

    //update
    void actualizarProductos(ProductoDTO productoDTO) throws ResourceNotFoundException;

    List<ProductoDTO> filtrarProductoPorCiudad(Long id) throws ResourceNotFoundException;

    List<ProductoDTO> filtrarProductoPorCategoria(Long id) throws ResourceNotFoundException;

    /*
    List<ProductoDTO> filtrarProductoPorCiudadYDosFechas(Long ciudadId, LocalDate fechaRecogida, LocalDate fechaEntrega) throws ResourceNotFoundException;*/

}
