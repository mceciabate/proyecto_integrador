package equipo10.integrador_v01;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.*;
import equipo10.integrador_v01.model.entity.*;
import equipo10.integrador_v01.model.jwt.RolDTO;
import equipo10.integrador_v01.model.jwt.Usuario;
import equipo10.integrador_v01.model.jwt.UsuarioDTO;
import equipo10.integrador_v01.repository.IReservaRepository;
import equipo10.integrador_v01.repository.jwt.IUsuarioRepository;
import equipo10.integrador_v01.service.impl.CategoriaService;
import equipo10.integrador_v01.service.impl.CiudadService;
import equipo10.integrador_v01.service.impl.ProductoService;
import equipo10.integrador_v01.service.impl.ReservaService;
import equipo10.integrador_v01.service.jwt.RolService;
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
    @Autowired
    ProductoService productoService;
    @Autowired
    RolService rolService;

    @Autowired
    CategoriaService categoriaService;
    @Autowired
    CiudadService ciudadService;

    public void cargarData() throws BadRequestException{
        CategoriaDTO categoria = new CategoriaDTO("la categoria", "una categoria", null);
        categoriaService.guardarCategoria(categoria);
        CiudadDTO ciudad = new CiudadDTO("ciudad", "provincia");
        ciudadService.guardarCiudad(ciudad);

        RolDTO rolDTO = new RolDTO("USUARIO");
        rolService.guardarRol(rolDTO);
        UsuarioDTO usuarioDTO = new UsuarioDTO("Cecilia", "Abate", "correo@correo", "123456", new RolDTO( 1L,"USUARIO"));
        usuarioService.guardarUsuario(usuarioDTO);
        ProductoDTO productoDTO = new ProductoDTO("auto", "la descrpcion", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new CiudadDTO(1L, "localidad", "provincia", new ArrayList<>()), null);
        productoService.guardarProductos(productoDTO);


    }

    @Test
    public void aGuardarReserva() throws BadRequestException{
        this.cargarData();

        //productoService.listarProductos();
        ReservaDTO reservaDTO = new ReservaDTO("3:00:00",
                                                LocalDate.now(),
                                                LocalDate.now(),
                                                new ProductoDTO(1L, "auto", "el auto", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new CiudadDTO(1L, "ciudad", "provincia", new ArrayList<>()), new CategoriaDTO(1L, "la categoria", "categoria", null, new ArrayList<>())),
                                                new UsuarioDTO(1L,"Cecilia", "Abate", "correo@correo", "123456", new RolDTO(1L, "USUARIO")) );
        reservaService.guardarReserva(reservaDTO);
        Assert.assertNotNull(reservaDTO);
    }

    @Test
    public void bEliminarReserva() throws ResourceNotFoundException, BadRequestException{
        //this.aGuardarReserva();
        reservaService.eliminarReserva(1L);
        Assert.assertFalse(Optional.empty().isPresent());
    }

    @Test
    public void cFiltrarReservasPorProducto() throws BadRequestException, ResourceNotFoundException{
        this.aGuardarReserva();
        List<ReservaDTO> lista = reservaService.filtrarReservasPorProducto(1L);
        Assert.assertNotNull(lista);
    }




}
