package equipo10.integrador_v01;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.jwt.UsuarioDTO;
import equipo10.integrador_v01.model.entity.jwt.Rol;
import equipo10.integrador_v01.repository.jwt.IUsuarioRepository;
import equipo10.integrador_v01.service.impl.jwt.UsuarioService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
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
    private UsuarioService usuarioService;
    @Autowired
    private IUsuarioRepository usuarioRepository;

        @Test
        public void aGuardarUsuarioTest() throws BadRequestException {
        Rol rol1 = new Rol();
        UsuarioDTO usuarioDTO1 = new UsuarioDTO("nombre1", "apellido1", "email1", "pass1", rol1);
        usuarioService.guardarUsuario(usuarioDTO1);
        Assert.assertEquals(usuarioDTO1.getEmail(), usuarioRepository.findById(1L).get().getEmail());
        }

        @Test
        public void bEliminarUsuarioTest() throws ResourceNotFoundException {
        usuarioService.eliminarUsuario(1L);
        Assert.assertNull(usuarioRepository.findById(1L));
        }
        @Test
        public void cListarUsuarioTest() throws BadRequestException {
        Rol rol2 = new Rol();
        Rol rol3 = new Rol();
        UsuarioDTO usuarioDTO2 = new UsuarioDTO("nombre2", "apellido2", "email2", "pass2", rol2);
        UsuarioDTO usuarioDTO3 = new UsuarioDTO("nombre3", "apellido3", "email3", "pass3", rol3);
        usuarioService.guardarUsuario(usuarioDTO2);
        usuarioService.guardarUsuario(usuarioDTO3);

        List<UsuarioDTO> usuariosListadoDTO = usuarioService.listarTodosUsuario();

        Assert.assertEquals(2, usuariosListadoDTO.size());
        }
        @Test
        public void dBuscarUsuarioPorIdTest() throws BadRequestException, ResourceNotFoundException {
        Rol rol4 = new Rol();
        UsuarioDTO usuarioDTO4 = new UsuarioDTO("nombre4", "apellido4", "email4", "pass4", rol4);
        usuarioService.guardarUsuario(usuarioDTO4);

        Assert.assertEquals(usuarioDTO4.getNombre(), usuarioService.buscarUsuarioPorId(3L).getNombre());
        }

        @Test
        public void eActualizarCategoriaTest() throws BadRequestException, ResourceNotFoundException {
        Rol rol5  = new Rol();
        UsuarioDTO usuarioDTO5 = new UsuarioDTO("nombre5", "apellido5", "email5", "pass5", rol5);
        usuarioService.guardarUsuario(usuarioDTO5);

        UsuarioDTO UsuarioDTO4modificado = new UsuarioDTO(5L, "nombre5", "apellidoMODIFICADO", "email5", "pass5", rol5);
        usuarioService.actualizarUsuario(UsuarioDTO4modificado);

        Assert.assertEquals("apellidoMODIFICADO", usuarioRepository.findById(5L).get().getApellido());
        }
}