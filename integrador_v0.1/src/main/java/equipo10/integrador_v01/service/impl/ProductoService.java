package equipo10.integrador_v01.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ProductoDTO;
import equipo10.integrador_v01.model.entity.Producto;
import equipo10.integrador_v01.repository.IProductoRepository;
import equipo10.integrador_v01.service.IProductoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductoService implements IProductoService {

    final static Logger log = Logger.getLogger(IProductoService.class);

    //Inyección de dependencias
    @Autowired
    IProductoRepository productoRepository;

    @Autowired
    ObjectMapper mapper;


    //sobreescribo el CRUD
    @Override
    public Set<ProductoDTO> listarProductos() {
        Set<ProductoDTO> listaProductosDTO = new HashSet<>();
        List<Producto> listaProductos = productoRepository.findAll();
        for(Producto producto: listaProductos){
            listaProductosDTO.add(mapper.convertValue(producto, ProductoDTO.class));
        }
        log.info("Listado de categorías: ");
        return listaProductosDTO;
    }

    @Override
    public ProductoDTO buscarProductosPorId(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        ProductoDTO productoDTO = null;
        if(producto.isPresent())
            productoDTO=mapper.convertValue(producto, ProductoDTO.class);

        log.info("Producto: " + id);
        return productoDTO;
    }

    @Override
    public ProductoDTO guardarProductos(ProductoDTO productoDTO) {
        Producto productoAGuardar = mapper.convertValue(productoDTO, Producto.class);
        productoRepository.save(productoAGuardar);
        log.info("Guardando nuevo producto: ");
        return productoDTO;
    }

    @Override
    public void eliminarProductos(Long id) throws ResourceNotFoundException {
        if (buscarProductosPorId(id) == null) {
            throw new ResourceNotFoundException("No se encontro ningun producto con el id: " + id);
        } else {
            log.info("Eliminando el producto: " + id);
            productoRepository.deleteById(id);
        }
    }

    @Override
    public void actualizarProductos(ProductoDTO productoDTO) throws ResourceNotFoundException {
        Optional<Producto> productoEncontrado = productoRepository.findById(productoDTO.getId());
        Producto productoActualizado = productoEncontrado.get();
        if (productoEncontrado == null) {
            throw new ResourceNotFoundException("No se encontro el producto para actualizar");
        }else{
            productoActualizado.setTitulo(productoDTO.getTitulo());
            productoActualizado.setDescripcion(productoDTO.getDescripcion());
            productoActualizado.setCaracteristica(productoDTO.getCaracteristica());
            productoActualizado.setCiudad(productoDTO.getCiudad());
            productoActualizado.setCategoria(productoDTO.getCategoria());
            productoRepository.saveAndFlush(productoActualizado);
        }
    }


}
