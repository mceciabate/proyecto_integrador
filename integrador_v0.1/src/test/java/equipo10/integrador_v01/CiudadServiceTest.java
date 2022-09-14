package equipo10.integrador_v01;

import com.fasterxml.jackson.databind.ObjectMapper;
import equipo10.integrador_v01.model.dto.CategoriaDTO;
import equipo10.integrador_v01.model.dto.CiudadDTO;
import equipo10.integrador_v01.model.dto.ImagenDTO;
import equipo10.integrador_v01.model.entity.Categoria;
import equipo10.integrador_v01.model.entity.Ciudad;
import equipo10.integrador_v01.repository.ICiudadRepository;
import equipo10.integrador_v01.service.impl.CiudadService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CiudadServiceTest {

    @Autowired
    private CiudadService ciudadService;
    @Autowired
    private ICiudadRepository ciudadRepository;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void aGuardarCiudadTest() {
        CiudadDTO ciudadDTO = new CiudadDTO("localidad1", "provincia1");
        ciudadService.guardarCiudad(ciudadDTO);
        Assert.assertTrue(ciudadRepository.findById(1L).get().getLocalidad() =="localidad1" );
    }

    @Test
    public void bListarCiudadTest() {

        CiudadDTO ciudadDTO2 = new CiudadDTO("localidad2", "provincia2");
        CiudadDTO ciudadDTO3 = new CiudadDTO("localidad3", "provincia3");

        List<Ciudad> ciudadLista = new ArrayList<>();
        ciudadLista.add(mapper.convertValue(ciudadDTO2, Ciudad.class));
        ciudadLista.add(mapper.convertValue(ciudadDTO3, Ciudad.class));

        ciudadService.guardarCiudad(ciudadDTO2);
        ciudadService.guardarCiudad(ciudadDTO3);

        List<CiudadDTO> listaCiudadEncontradas = ciudadService.listarCiudades();

        Assert.assertEquals(2, listaCiudadEncontradas.size());
        Assert.assertTrue(listaCiudadEncontradas.size()==2);
    }
}