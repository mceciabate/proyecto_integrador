package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.jwt.UsuarioDTO;
import equipo10.integrador_v01.service.jwt.EmailSenderService;
import equipo10.integrador_v01.service.jwt.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    private EmailSenderService emailSenderService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> traerTodosUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodosUsuario());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> traerUnUsuario(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        String contraseniaEncriptada = passwordEncoder.encode(usuarioDTO.getContrasenia());
        usuarioDTO.setContrasenia(contraseniaEncriptada);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(usuarioDTO.getEmail());
        mailMessage.setSubject("Bienvenido a Ubicar");
        mailMessage.setText("Su usuario ha sido creado exitosamente, por favor inicie sesión ingresando a http://ubicar.ddns.net/");
        mailMessage.setFrom("${spring.mail.username}");
        emailSenderService.sendEmail(mailMessage);
        return ResponseEntity.ok(usuarioService.guardarUsuario(usuarioDTO));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) throws ResourceNotFoundException {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario: " + id + " fue eliminado con exito.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> modificarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) throws ResourceNotFoundException {
        String contraseniaEncriptada = passwordEncoder.encode(usuarioDTO.getContrasenia());
        usuarioDTO.setContrasenia(contraseniaEncriptada);
        usuarioService.actualizarUsuario(usuarioDTO);
        return ResponseEntity.ok("Usuario: " + id + " fue actualizado con exito.");
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> buscarUserPorEmail(@PathVariable("email") String email) throws ResourceNotFoundException {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

}
