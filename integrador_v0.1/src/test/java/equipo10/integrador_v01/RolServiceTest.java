package equipo10.integrador_v01;

import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.jwt.RolDTO;
import equipo10.integrador_v01.repository.jwt.IRolRepository;
import equipo10.integrador_v01.service.jwt.RolService;
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
public class RolServiceTest {
    @Autowired
    RolService rolService;
    @Autowired
    IRolRepository rolRepository;

    @Test
    public void aGuardarRolTest(){
        RolDTO rol1 = new RolDTO("admin");
        rolService.guardarRol(rol1);
        Assert.assertEquals(rol1.getNombre(), rolRepository.findById(1L).get().getNombre());
    }

    @Test
    public void bEliminarRolTest() throws ResourceNotFoundException {
        rolService.eliminarRol(1L);
        Assert.assertFalse(rolRepository.findById(1L).isPresent());
    }

    @Test
    public void cListarRolesTest() {
        RolDTO rol2 = new RolDTO();
        RolDTO rol3 = new RolDTO();
        rolService.guardarRol(rol2);
        rolService.guardarRol(rol3);

        List<RolDTO> rolesListadoDTO = rolService.listarTodosRoles();

        Assert.assertEquals(2, rolesListadoDTO.size());
    }
    @Test
    public void dBuscarRolPorIdTest() throws ResourceNotFoundException {
        RolDTO rol4 = new RolDTO();
        rolService.guardarRol(rol4);

        Assert.assertEquals(rol4.getNombre(), rolService.buscarRolesPorId(4L).getNombre());
    }

    @Test
    public void eActualizarRolTest() throws ResourceNotFoundException {
        RolDTO rol5  = new RolDTO("nombre");
        rolService.guardarRol(rol5);

        RolDTO rolModificado = new RolDTO(5L, "nombreModificado");
        rolService.actualizarRol(rolModificado);

        Assert.assertEquals("nombreModificado", rolRepository.findById(5L).get().getNombre());
    }

}