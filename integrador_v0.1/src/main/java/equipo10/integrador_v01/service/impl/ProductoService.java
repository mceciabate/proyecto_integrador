package equipo10.integrador_v01.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ProductoDTO;
import equipo10.integrador_v01.model.entity.Categoria;
import equipo10.integrador_v01.model.entity.Ciudad;
import equipo10.integrador_v01.model.entity.Producto;
import equipo10.integrador_v01.repository.*;
import equipo10.integrador_v01.service.IProductoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductoService implements IProductoService {

    final static Logger log = Logger.getLogger(IProductoService.class);

    //Inyección de dependencias
    @Autowired
    IProductoRepository productoRepository;
    @Autowired
    IImagenRepository imagenRepository;
    @Autowired
    ICaracteristicaRepository caracteristicaRepository;
    @Autowired
    IPoliticaRepository politicaRepository;
    @Autowired
    ICiudadRepository ciudadRepository;
    @Autowired
    ICategoriaRepository categoriaRepository;

    @Autowired
    ObjectMapper mapper;

    //sobreescribo el CRUD

    public Set<ProductoDTO> listarProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        Set<ProductoDTO> listaProductosDTO = new HashSet<>();

        for (Producto producto : listaProductos) {
            listaProductosDTO.add(mapper.convertValue(producto, ProductoDTO.class));
        }

        log.info("Listado de categorías: " + listaProductos.toString());
        return listaProductosDTO;
    }

    @Override
    public ProductoDTO buscarProductosPorId(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        ProductoDTO productoDTO = null;
        if (producto.isPresent())
            productoDTO = mapper.convertValue(producto, ProductoDTO.class);

        log.info("Producto: " + id + productoDTO.toString());
        return productoDTO;
    }

    @Override
    public ProductoDTO guardarProductos(ProductoDTO productoDTO) throws BadRequestException {

        /*if (productoDTO.getImagen() == null || productoDTO.getCaracteristica() == null || productoDTO.getCiudad() == null || productoDTO.getCategoria() == null) {
            throw new BadRequestException("No se pudo guardar el producto");
        } else {*/
        Producto productoAGuardar = mapper.convertValue(productoDTO, Producto.class);
        Ciudad ciudadSeteada = ciudadRepository.findById(productoAGuardar.getCiudad().getId()).get();
        Categoria categoriaSeteada = categoriaRepository.findById(productoAGuardar.getCategoria().getId()).get();
        productoAGuardar.setCiudad(ciudadSeteada);
        productoAGuardar.setCategoria(categoriaSeteada);
        productoRepository.save(productoAGuardar);
        log.info("Guardando nuevo producto: " + productoDTO.toString());
        return mapper.convertValue(productoAGuardar, ProductoDTO.class);

        /*}*/

        /*Producto producto = mapper.convertValue(productoDTO, Producto.class);
        productoRepository.save(producto);
        log.info("Guardando nuevo producto: " + productoDTO.toString());
        return productoDTO;*/
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
        } else {
            productoActualizado.setTitulo(productoDTO.getTitulo());
            productoActualizado.setDescripcion(productoDTO.getDescripcion());
            productoActualizado.setCaracteristica((productoDTO.getCaracteristica()));
            productoActualizado.setCiudad(productoDTO.getCiudad());
            productoActualizado.setCategoria(productoDTO.getCategoria());
            log.info("Producto : " + productoActualizado.getId() + " actualizado.");
            productoRepository.saveAndFlush(productoActualizado);
        }
    }

    @Override
    public List<ProductoDTO> filtrarProductoPorCiudad(Long id) throws ResourceNotFoundException {
        //List<ProductoDTO> productosEncontrados = new ArrayList<>();
        List<ProductoDTO> listadoCompleto = (List<ProductoDTO>) this.listarProductos();
        for (ProductoDTO productoDTO : listadoCompleto) {
            if (productoDTO.getCiudad().getId() == id) {
                listadoCompleto.add(productoDTO);
            }
        }
        return listadoCompleto;
    }


}
