package equipo10.integrador_v01.service.impl;

import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ProductoDTO;
import equipo10.integrador_v01.repository.IProductoRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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
        public void aGuardarProductoTest() {
            ProductoDTO ProductoDTO1 = new ProductoDTO("titulo1", "descrip1");
            productoService.guardarProductos(ProductoDTO1);

            Assert.assertEquals(ProductoDTO1.getTitulo(), productoRepository.findById(1L).get().getTitulo());
        }

        @Test
        public void bEliminarProductoTest() throws ResourceNotFoundException {
            productoService.eliminarProductos(1L);
            Assert.assertTrue(productoRepository.findById(1L).isEmpty());
        }
        @Test
        public void cListarCategoriaTest() {
            ProductoDTO productoDTO2 = new ProductoDTO("titulo2", "descrip2");
            productoService.guardarProductos(productoDTO2);

            ProductoDTO productoDTO3 = new ProductoDTO("titulo3", "descrip3");
            productoService.guardarProductos(productoDTO3);

            Set<ProductoDTO> listaProductosEncontrados = productoService.listarProductos();

            Assert.assertEquals(2, listaProductosEncontrados.size());
        }
        @Test
        public void dBuscarCategoriaPorIdTest() {
            ProductoDTO productoDTO4 = new ProductoDTO("titulo4", "descrip4");
            productoService.guardarProductos(productoDTO4);

            Assert.assertEquals(productoDTO4.getTitulo(), productoService.buscarProductosPorId(4L).getTitulo());
        }

        @Test
        public void eActualizarCategoriaTest() {
            ProductoDTO productoDTO5 = new ProductoDTO("titulo5", "decrip5");
            productoService.guardarProductos(productoDTO5);

            ProductoDTO productoDTO6 = new ProductoDTO("titulo6", "descrip6");
            productoService.guardarProductos(productoDTO6);

            Assert.assertEquals("titulo5 Modif", productoRepository.findById(5L).get().getTitulo());
        }


}