package equipo10.integrador_v01.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.CategoriaDTO;
import equipo10.integrador_v01.model.entity.Categoria;
import equipo10.integrador_v01.model.entity.Producto;
import equipo10.integrador_v01.repository.ICategoriaRepository;
import equipo10.integrador_v01.repository.IProductoRepository;
import equipo10.integrador_v01.service.ICategoriaService;
import equipo10.integrador_v01.service.IProductoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    final static Logger log = Logger.getLogger(IProductoService.class);

    //Inyección de dependencias
    @Autowired
    IProductoRepository productoRepository;


    //sobreescribo el CRUD
    @Override
    public List<Producto> listarProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        log.info("Listado de categorías: ");
        return listaProductos;
    }

    @Override
    public Producto buscarProductosPorId(Long id) {
        Producto productoEncontrado = productoRepository.findById(id).orElse(null);
        log.info("Producto: " + id);
        return productoEncontrado;
    }

    @Override
    public Producto guardarProductos(Producto producto) {
        Producto productoAGuardar = productoRepository.save(producto);
        log.info("Guardando nuevo producto: ");
        return productoAGuardar;
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
    public void actualizarProductos(Producto producto) throws ResourceNotFoundException {
        if (productoRepository.findById(producto.getId()) == null) {
            throw new ResourceNotFoundException("No se encontro el producto para actualizar");
        }else{
        productoRepository.saveAndFlush(producto);
        }
    }


}
