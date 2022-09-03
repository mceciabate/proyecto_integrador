package equipo10.integrador_v01.service.jwt;

import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.jwt.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {
    //find
    List<UsuarioDTO> listarTodosUsuario();

    UsuarioDTO buscarUsuarioPorId(Long id) throws ResourceNotFoundException;

    /*
    UsuarioDTO buscarUsuarioPorEmail(String email);
    */

    //create
    UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO);

    //delete
    void eliminarUsuario(Long id) throws ResourceNotFoundException;

    //update
    void actualizarUsuario(UsuarioDTO usuarioDTO) throws ResourceNotFoundException;
}