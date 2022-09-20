package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.jwt.RolDTO;
import equipo10.integrador_v01.service.jwt.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    IRolService rolService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<RolDTO>> traerTodosRoles() {
        return ResponseEntity.ok(rolService.listarTodosRoles());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RolDTO> traerUnRol(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(rolService.buscarRolesPorId(id));
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<RolDTO> guardarRol(@RequestBody RolDTO rolDTO) {
        return ResponseEntity.ok(rolService.guardarRol(rolDTO));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarRol(@PathVariable Long id) throws ResourceNotFoundException {
        rolService.eliminarRol(id);
        return ResponseEntity.ok("Rol: " + id + " fue eliminado con exito.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> modificarRol(@PathVariable Long id, @RequestBody RolDTO rolDTO) throws ResourceNotFoundException {
        rolService.actualizarRol(rolDTO);
        return ResponseEntity.ok("Rol: " + id + " fue actualizado con exito.");
    }

}