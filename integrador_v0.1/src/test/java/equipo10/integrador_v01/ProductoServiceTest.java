package equipo10.integrador_v01;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.*;
import equipo10.integrador_v01.repository.IProductoRepository;
import equipo10.integrador_v01.service.impl.CategoriaService;
import equipo10.integrador_v01.service.impl.CiudadService;
import equipo10.integrador_v01.service.impl.ProductoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoServiceTest {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private IProductoRepository productoRepository;
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CiudadService ciudadService;

    public void cargarData() {
        CategoriaDTO categoria = new CategoriaDTO("la categoria", "una categoria", null);
        categoriaService.guardarCategoria(categoria);
        CiudadDTO ciudad = new CiudadDTO("ciudad", "provincia", "Direccion");
        ciudadService.guardarCiudad(ciudad);

    }

    @Test
    public void aGuardarProductoTest() throws BadRequestException {
        this.cargarData();
        List<ImagenDTO> imagenes = new ArrayList<>();
        List<CaracteristicaDTO> caracteristicas = new ArrayList<>();
        List<PoliticaDTO> politicas = new ArrayList<>();
        ProductoDTO productoDTO = new ProductoDTO("titulo1", "descrip", imagenes, caracteristicas, politicas, new CiudadDTO(1L, "ciudad", "provincia", "Direccion", new ArrayList<>()), null);
        productoService.guardarProductos(productoDTO);
        Assert.assertEquals(productoDTO.getTitulo(), productoRepository.findById(1L).get().getTitulo());
    }

    @Test
    public void bEliminarProductoTest() throws ResourceNotFoundException, BadRequestException {
        productoService.eliminarProductos(1L);
        Assert.assertFalse(productoRepository.findById(1L).isPresent());
    }

    @Test
    public void cListarProductosTest() throws BadRequestException {
        this.cargarData();
        List<ImagenDTO> imagenes = new ArrayList<>();
        List<CaracteristicaDTO> caracteristicas = new ArrayList<>();
        List<PoliticaDTO> politicas = new ArrayList<>();
        ProductoDTO productoDTO = new ProductoDTO("titulo1", "descrip", imagenes, caracteristicas, politicas, new CiudadDTO(1L, "localidad", "provincia", "Direccion", new ArrayList<>()), null);
        productoService.guardarProductos(productoDTO);

        List<ImagenDTO> imagen2 = new ArrayList<>();
        List<CaracteristicaDTO> caracteristicas2 = new ArrayList<>();
        List<PoliticaDTO> politicas2 = new ArrayList<>();
        CiudadDTO ciudad2 = new CiudadDTO();
        CategoriaDTO categoria2 = new CategoriaDTO();
        ProductoDTO productoDTO2 = new ProductoDTO("titulo2", "descrip2", imagen2, caracteristicas2, politicas2, new CiudadDTO(1L, "localidad", "provincia", "Direccion", new ArrayList<>()), null);
        productoService.guardarProductos(productoDTO2);

        List<ProductoDTO> listaProductosEncontrados = productoService.listarProductos();

        Assert.assertEquals(2, listaProductosEncontrados.size());
    }

    @Test
    public void dBuscarProductoPorIdTest() throws BadRequestException {
        this.cargarData();
        List<ImagenDTO> imagen2 = new ArrayList<>();
        List<CaracteristicaDTO> caracteristicas2 = new ArrayList<>();
        List<PoliticaDTO> politicas2 = new ArrayList<>();
        CiudadDTO ciudad2 = new CiudadDTO();
        CategoriaDTO categoria2 = new CategoriaDTO();
        ProductoDTO productoDTO2 = new ProductoDTO("titulo2", "descrip2", imagen2, caracteristicas2, politicas2, new CiudadDTO(1L, "localidad", "provincia", "Direccion", new ArrayList<>()), null);
        productoService.guardarProductos(productoDTO2);

        Assert.assertEquals(productoDTO2.getTitulo(), productoService.buscarProductosPorId(3L).getTitulo());
    }

    @Test
    public void eActualizarProductoTest() throws BadRequestException, ResourceNotFoundException {
        this.cargarData();
        List<ImagenDTO> imagen2 = new ArrayList<>();
        List<CaracteristicaDTO> caracteristicas2 = new ArrayList<>();
        List<PoliticaDTO> politicas2 = new ArrayList<>();
        CiudadDTO ciudad2 = new CiudadDTO();
        CategoriaDTO categoria2 = new CategoriaDTO();
        ProductoDTO productoDTO2 = new ProductoDTO("titulo2", "descrip2", imagen2, caracteristicas2, politicas2, new CiudadDTO(1L, "alguna", "alguna", "Direccion", new ArrayList<>()), null);
        productoService.guardarProductos(productoDTO2);

        ProductoDTO productoDTO5M = new ProductoDTO(5L, "tituloMODIFICADO", "descrip5", imagen2, caracteristicas2, politicas2, new CiudadDTO(1L, "alguna", "alguna", "Direccion", new ArrayList<>()), null);
        productoService.actualizarProductos(productoDTO5M);

        Assert.assertEquals("tituloMODIFICADO", productoRepository.findById(5L).get().getTitulo());
    }


}