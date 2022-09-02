package equipo10.integrador_v01.service.impl.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.jwt.RolDTO;
import equipo10.integrador_v01.model.entity.jwt.Rol;
import equipo10.integrador_v01.repository.jwt.IRolRepository;
import equipo10.integrador_v01.service.jwt.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolService {
    @Autowired
    IRolRepository rolRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public List<RolDTO> listarTodosRoles() {
        List<Rol> rolesEncontrados = rolRepository.findAll();
        List<RolDTO> rolesEncontradosDTO = new ArrayList<>();
        for(Rol rol: rolesEncontrados){
            rolesEncontradosDTO.add(mapper.convertValue(rol, RolDTO.class));
        }
        return rolesEncontradosDTO;
    }

    @Override
    public RolDTO buscarRolesPorId(Long id) {
        return mapper.convertValue(rolRepository.findById(id), RolDTO.class);
    }

    @Override
    public RolDTO guardarRol(RolDTO rolDTO) {
        return mapper.convertValue(rolRepository.save(mapper.convertValue(rolDTO, Rol.class)),RolDTO.class);
    }

    @Override
    public void eliminarRol(Long id) throws ResourceNotFoundException {
        Optional<Rol> rolEncontrado = rolRepository.findById(id);
        if(rolEncontrado.isPresent()){
            rolRepository.deleteById(id);
        }else
            throw new ResourceNotFoundException("No se encontro ningun usuario con el id: " + id);
    }


    @Override
    public void actualizarRol(RolDTO rolDTO) throws ResourceNotFoundException {
        Optional<Rol> rolEncontrado = rolRepository.findById(rolDTO.getId());
        if(rolEncontrado.isPresent()){
            Rol rolAActualizar = mapper.convertValue(rolDTO, Rol.class);
            rolAActualizar.setId(rolDTO.getId());
            rolAActualizar.setNombre(rolDTO.getNombre());
            rolRepository.saveAndFlush(rolAActualizar);
        } else throw new ResourceNotFoundException("No se puede modificar un id inexistente");
    }
}
