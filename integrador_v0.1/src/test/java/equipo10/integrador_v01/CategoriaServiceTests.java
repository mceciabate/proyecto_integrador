package equipo10.integrador_v01;

import equipo10.integrador_v01.model.dto.CategoriaDTO;
import equipo10.integrador_v01.repository.ICategoriaRepository;
import equipo10.integrador_v01.service.impl.CategoriaService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaServiceTests {
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ICategoriaRepository categoriaRepository;
    @Test
    public void aGuardarCategoriaTest() {
        CategoriaDTO categoriaDTO1 = new CategoriaDTO("Imagen Test", "Test: test test test, test test test.", ":./img/test1");
        categoriaService.guardarCategoria(categoriaDTO1);

        Assert.assertEquals(categoriaDTO1.getTitulo(), categoriaRepository.findById(1L).get().getTitulo());
    }

    @Test
    public void bEliminarCategoriaTest() {
        categoriaService.eliminarCategoria(1L);
        Assert.assertTrue(categoriaRepository.findById(1L).isEmpty());
    }
    @Test
    public void cListarCategoriaTest() {
        CategoriaDTO categoriaDTO2 = new CategoriaDTO("Imagen Test2", "Test2: test test test, test test test.", ":./img/test2");
        categoriaService.guardarCategoria(categoriaDTO2);

        CategoriaDTO categoriaDTO3 = new CategoriaDTO("Imagen Test3", "Test3: test test test, test test test.", ":./img/test3");
        categoriaService.guardarCategoria(categoriaDTO3);

        Assert.assertEquals(2, categoriaService.listarCategoria().size());
    }
    @Test
    public void dBuscarCategoriaPorIdTest() {
        CategoriaDTO categoriaDTO4 = new CategoriaDTO("Imagen Test4", "Test4: test test test, test test test.", ":./img/test4");
        categoriaService.guardarCategoria(categoriaDTO4);

        Assert.assertEquals(categoriaDTO4.getTitulo(), categoriaService.buscarCategoriaPorId(4L).getTitulo());
    }

    @Test
    public void eActualizarCategoriaTest() {
        CategoriaDTO categoriaDTO5 = new CategoriaDTO("Imagen Test5", "Test5: test test test, test test test.", ":./img/test5");
        categoriaService.guardarCategoria(categoriaDTO5);

        CategoriaDTO categoriaDTO5M = new CategoriaDTO("Imagen Test5 Modif", "Test5 Modif: test test test, test test test.", ":./img/test5Modif");
        categoriaService.actualizarCategoria(5L, categoriaDTO5M);

        Assert.assertEquals("Imagen Test5 Modif", categoriaRepository.findById(5L).get().getTitulo());
    }

}