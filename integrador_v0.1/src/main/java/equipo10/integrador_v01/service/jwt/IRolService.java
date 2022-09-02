package equipo10.integrador_v01.service.jwt;

import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.jwt.RolDTO;

import java.util.List;

public interface IRolService {
    //find
    List<RolDTO> listarTodosRoles();

    RolDTO buscarRolesPorId(Long id);

    //create
    RolDTO guardarRol(RolDTO rolDTO);

    //delete
    void eliminarRol(Long id) throws ResourceNotFoundException;

    //update
    void actualizarRol(RolDTO rolDTO) throws ResourceNotFoundException;
}
