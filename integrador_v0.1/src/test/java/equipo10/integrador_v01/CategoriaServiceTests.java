package equipo10.integrador_v01;

import equipo10.integrador_v01.repository.ICategoriaRepository;
import equipo10.integrador_v01.service.impl.CategoriaService;
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
    private CategoriaService odontologoService;
    @Autowired
    private ICategoriaRepository odontologoRepository;

    @Test
    public void aGuardarCategoriaTest() {

    }

    @Test
    public void bListarCategoriaTest() {

    }
    @Test
    public void cBuscarCategoriaPorIdTest() {

    }

    @Test
    public void dActualizarCategoriaTest() {

    }

    @Test
    public void eEliminarCategoriaTest() {

    }

}
