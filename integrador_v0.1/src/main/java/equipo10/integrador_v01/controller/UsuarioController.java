package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ProductoDTO;
import equipo10.integrador_v01.model.dto.jwt.UsuarioDTO;
import equipo10.integrador_v01.service.jwt.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> traerTodosUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodosUsuario());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }


}
