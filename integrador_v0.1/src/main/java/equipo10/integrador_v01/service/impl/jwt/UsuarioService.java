package equipo10.integrador_v01.service.impl.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.jwt.UsuarioDTO;
import equipo10.integrador_v01.model.entity.jwt.Usuario;
import equipo10.integrador_v01.repository.jwt.IUsuarioRepository;
import equipo10.integrador_v01.service.jwt.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public List<UsuarioDTO> listarTodosUsuario() {
        List<Usuario> usuariosEncontrados = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosEncontradosDTO = new ArrayList<>();
        for(Usuario usuario: usuariosEncontrados){
            usuariosEncontradosDTO.add(mapper.convertValue(usuario, UsuarioDTO.class));
        }
        return usuariosEncontradosDTO;
    }

    @Override
    public UsuarioDTO buscarUsuarioPorId(Long id) throws ResourceNotFoundException {
        if (usuarioRepository.findById(id).isPresent()) {
            return mapper.convertValue(usuarioRepository.findById(id), UsuarioDTO.class);
        } else throw new ResourceNotFoundException("No se encontro ningun usuario con el id: " + id);
    }

    @Override
    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        return mapper.convertValue(usuarioRepository.buscarporEmail(email), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        return mapper.convertValue(usuarioRepository.save(mapper.convertValue(usuarioDTO, Usuario.class)),UsuarioDTO.class);
    }

    @Override
    public void eliminarUsuario(Long id) throws ResourceNotFoundException {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if(usuarioEncontrado.isPresent()){
             usuarioRepository.deleteById(id);
        }else
            throw new ResourceNotFoundException("No se encontro ningun usuario con el id: " + id);
    }

    @Override
    public void actualizarUsuario(UsuarioDTO usuarioDTO) throws ResourceNotFoundException {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(usuarioDTO.getId());
        if(usuarioEncontrado.isPresent()){
            Usuario usuarioAActualizar = mapper.convertValue(usuarioDTO, Usuario.class);
            usuarioAActualizar.setApellido(usuarioDTO.getApellido());
            usuarioAActualizar.setNombre(usuarioDTO.getNombre());
            usuarioAActualizar.setEmail(usuarioDTO.getEmail());
            usuarioAActualizar.setContrasenia(usuarioDTO.getContrasenia());
            usuarioAActualizar.setRol(usuarioDTO.getRol());
            usuarioAActualizar.setId(usuarioDTO.getId());
            usuarioRepository.saveAndFlush(usuarioAActualizar);
        } else throw new ResourceNotFoundException("No se puede modificar un id inexistente");
    }
}
