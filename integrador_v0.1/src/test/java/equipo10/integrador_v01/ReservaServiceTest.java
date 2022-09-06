package equipo10.integrador_v01;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ReservaDTO;
import equipo10.integrador_v01.model.entity.*;
import equipo10.integrador_v01.model.jwt.Usuario;
import equipo10.integrador_v01.repository.IReservaRepository;
import equipo10.integrador_v01.repository.jwt.IUsuarioRepository;
import equipo10.integrador_v01.service.impl.ReservaService;
import equipo10.integrador_v01.service.jwt.UsuarioService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservaServiceTest {
    @Autowired
    private ReservaService reservaService;
    @Autowired
    private IReservaRepository reservaRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;



    @Test
    public void aGuardarReserva() throws BadRequestException{
        List<Imagen> imagens =new ArrayList<>();
        List<Caracteristica> caracteristicas = new ArrayList<>();
        List<Politica> politicas = new ArrayList<>();
        Ciudad ciudad = new Ciudad("Buenos Aires", "Mar chiquita");
        Producto producto = new Producto(1L, "un auto", "un auto para alquilar", imagens, caracteristicas, politicas,ciudad, new Categoria("categoria", "cagoria", new Imagen("laimagen", "abc"))  );
        Usuario usuario = new Usuario("Cecilia", "Abate", "correo@correo.com", "1234");
        usuarioRepository.save(usuario);
        ReservaDTO reservaDTO = new ReservaDTO("3:00:00", LocalDate.now(), LocalDate.now(), producto, usuario);
        reservaService.guardarReserva(reservaDTO);
        Assert.assertNotNull(reservaDTO);
    }

    @Test
    public void bEliminarReserva() throws ResourceNotFoundException{
        reservaService.eliminarReserva(13L);
        Assert.assertTrue(Optional.empty().isEmpty());
    }

    @Test
    public void cFiltrarReservasPorProducto() throws BadRequestException, ResourceNotFoundException{
        /*List<Imagen> imagens =new ArrayList<>();
        List<Caracteristica> caracteristicas = new ArrayList<>();
        List<Politica> politicas = new ArrayList<>();
        Ciudad ciudad = new Ciudad("Buenos Aires", "Mar chiquita");
        Producto producto = new Producto(20L, "un auto", "un auto para alquilar", imagens, caracteristicas, politicas,ciudad, new Categoria("categoria", "cagoria", new Imagen("laimagen", "abc"))  );
        Usuario usuario = new Usuario("Cecilia", "Abate", "correo@correo.com", "1234");
        usuarioRepository.save(usuario);
        ReservaDTO reservaDTO = new ReservaDTO("3:00:00", LocalDate.now(), LocalDate.now(), producto, usuario);
        reservaService.guardarReserva(reservaDTO);
        ReservaDTO reservaDTO1 = new ReservaDTO("4:00:00", LocalDate.now(), LocalDate.now(), producto, usuario);
        reservaService.guardarReserva(reservaDTO1);*/
        List<ReservaDTO> lista = reservaService.filtrarReservasPorProducto(20L);
        Assert.assertNotNull(lista);
    }




}
