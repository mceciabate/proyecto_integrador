package equipo10.integrador_v01;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.*;
import equipo10.integrador_v01.repository.IProductoRepository;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoServiceTest {

   @Autowired
   private ProductoService productoService;
   @Autowired
   private IProductoRepository productoRepository;


        @Test
        public void aGuardarProductoTest() throws BadRequestException {
            List<ImagenDTO> imagen = new ArrayList<>();
            List<CaracteristicaDTO> caracteristicas = new ArrayList<>();
            List<PoliticaDTO> politicas = new ArrayList<>();
            CiudadDTO ciudad = new CiudadDTO();
            CategoriaDTO categoria = new CategoriaDTO();
            ProductoDTO productoDTO = new ProductoDTO("titulo1", "descrip", imagen, caracteristicas, politicas ,ciudad, categoria);
            productoService.guardarProductos(productoDTO);
            Assert.assertEquals(productoDTO.getTitulo(), productoRepository.findById(1L).get().getTitulo());
        }

        @Test
        public void bEliminarProductoTest() throws ResourceNotFoundException {
            productoService.eliminarProductos(1L);
            Assert.assertNull(productoRepository.findById(1L));
            //Assert.assertTrue(productoRepository.findById(1L).isEmpty());
        }
        @Test
        public void cListarCategoriaTest() throws BadRequestException {
            List<ImagenDTO> imagen1 = new ArrayList<>();
            List<CaracteristicaDTO> caracteristicas1 = new ArrayList<>();
            List<PoliticaDTO> politicas1 = new ArrayList<>();
            CiudadDTO ciudad1 = new CiudadDTO();
            CategoriaDTO categoria1 = new CategoriaDTO();
            ProductoDTO productoDTO1 = new ProductoDTO("titulo1", "descrip1", imagen1, caracteristicas1, politicas1,ciudad1, categoria1);
            productoService.guardarProductos(productoDTO1);

            List<ImagenDTO> imagen2 = new ArrayList<>();
            List<CaracteristicaDTO> caracteristicas2 = new ArrayList<>();
            List<PoliticaDTO> politicas2 = new ArrayList<>();
            CiudadDTO ciudad2 = new CiudadDTO();
            CategoriaDTO categoria2 = new CategoriaDTO();
            ProductoDTO productoDTO2 = new ProductoDTO("titulo2", "descrip2", imagen2, caracteristicas2, politicas2 ,ciudad2, categoria2);
            productoService.guardarProductos(productoDTO2);

            List<ProductoDTO> listaProductosEncontrados = productoService.listarProductos();

            Assert.assertEquals(2, listaProductosEncontrados.size());
        }
        @Test
        public void dBuscarCategoriaPorIdTest() throws BadRequestException {
            List<ImagenDTO> imagen4 = new ArrayList<>();
            List<CaracteristicaDTO> caracteristicas4 = new ArrayList<>();
            List<PoliticaDTO> politicas4 = new ArrayList<>();
            CiudadDTO ciudad4 = new CiudadDTO();
            CategoriaDTO categoria4 = new CategoriaDTO();
            ProductoDTO productoDTO4 = new ProductoDTO("titulo4", "descrip4", imagen4, caracteristicas4, politicas4 ,ciudad4, categoria4);
            productoService.guardarProductos(productoDTO4);

            Assert.assertEquals(productoDTO4.getTitulo(), productoService.buscarProductosPorId(4L).getTitulo());
        }

        @Test
        public void eActualizarCategoriaTest() throws BadRequestException, ResourceNotFoundException {
            List<ImagenDTO> imagen5 = new ArrayList<>();
            List<CaracteristicaDTO> caracteristicas5 = new ArrayList<>();
            List<PoliticaDTO> politicas5 = new ArrayList<>();
            CiudadDTO ciudad5 = new CiudadDTO();
            CategoriaDTO categoria5 = new CategoriaDTO();
            ProductoDTO productoDTO5 = new ProductoDTO("titulo5", "descrip5", imagen5, caracteristicas5, politicas5 ,ciudad5, categoria5);
            productoService.guardarProductos(productoDTO5);

            ProductoDTO productoDTO5M = new ProductoDTO(5L, "tituloMODIFICADO", "descrip5", imagen5, caracteristicas5, politicas5 ,ciudad5, categoria5);
            productoService.actualizarProductos(productoDTO5M);

            Assert.assertEquals("tituloMODIFICADO", productoRepository.findById(5L).get().getTitulo());
        }




}