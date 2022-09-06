package equipo10.integrador_v01;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.jwt.Rol;
import equipo10.integrador_v01.model.jwt.RolDTO;
import equipo10.integrador_v01.model.jwt.UsuarioDTO;
import equipo10.integrador_v01.repository.jwt.IUsuarioRepository;
import equipo10.integrador_v01.service.jwt.UsuarioService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceTest {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    IUsuarioRepository usuarioRepository;

    @Test
    public void aGuardarUsuarioTest(){
        RolDTO rol1 = new RolDTO("admin");
        UsuarioDTO usuarioDTO1 = new UsuarioDTO("nombre1", "apellido1", "email1", "pass1", rol1);
        usuarioService.guardarUsuario(usuarioDTO1);
        Assert.assertEquals(usuarioDTO1.getEmail(), usuarioRepository.findById(1L).get().getEmail());
        Assert.assertEquals(usuarioDTO1.getNombre(), usuarioRepository.findById(1L).get().getNombre());
        Assert.assertEquals(usuarioDTO1.getApellido(), usuarioRepository.findById(1L).get().getApellido());

    }

    @Test
    public void bEliminarUsuarioTest() throws ResourceNotFoundException {
        usuarioService.eliminarUsuario(1L);
        Assert.assertTrue(usuarioRepository.findById(1L).isEmpty());
    }

    @Test
    public void cListarUsuarioTest() {
        RolDTO rol2 = new RolDTO();
        RolDTO rol3 = new RolDTO();
        UsuarioDTO usuarioDTO2 = new UsuarioDTO("nombre2", "apellido2", "email2", "pass2", rol2);
        UsuarioDTO usuarioDTO3 = new UsuarioDTO("nombre3", "apellido3", "email3", "pass3", rol3);
        usuarioService.guardarUsuario(usuarioDTO2);
        usuarioService.guardarUsuario(usuarioDTO3);

        List<UsuarioDTO> usuariosListadoDTO = usuarioService.listarTodosUsuario();

        Assert.assertEquals(2, usuariosListadoDTO.size());
    }
    @Test
    public void dBuscarUsuarioPorIdTest() throws ResourceNotFoundException {
        RolDTO rol4 = new RolDTO();
        UsuarioDTO usuarioDTO4 = new UsuarioDTO("nombre4", "apellido4", "email4", "pass4", rol4);
        usuarioService.guardarUsuario(usuarioDTO4);

        Assert.assertEquals(usuarioDTO4.getNombre(), usuarioService.buscarUsuarioPorId(4L).getNombre());
    }

    @Test
    public void eActualizarCategoriaTest() throws ResourceNotFoundException {
        RolDTO rol5  = new RolDTO();
        UsuarioDTO usuarioDTO5 = new UsuarioDTO("nombre5", "apellido5", "email5", "pass5", rol5);
        usuarioService.guardarUsuario(usuarioDTO5);

        UsuarioDTO UsuarioDTO4modificado = new UsuarioDTO(5L, "nombre5", "apellidoMODIFICADO", "email5", "pass5", rol5);
        usuarioService.actualizarUsuario(UsuarioDTO4modificado);

        Assert.assertEquals("apellidoMODIFICADO", usuarioRepository.findById(5L).get().getApellido());
    }
}