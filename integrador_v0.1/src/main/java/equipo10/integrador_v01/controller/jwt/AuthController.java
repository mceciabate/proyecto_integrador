package equipo10.integrador_v01.controller.jwt;

import equipo10.integrador_v01.config.security.jwt.JwtProviderConfig;
import equipo10.integrador_v01.model.jwt.JwtDTO;
import equipo10.integrador_v01.model.jwt.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProviderConfig jwtProviderConfig;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> token(@RequestBody UsuarioDTO usuarioDTO) {
        Map<String, Object> response = new HashMap<>();

        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getContrasenia()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProviderConfig.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, "Bearer", userDetails.getUsername(), userDetails.getAuthorities());
        response.put("respuesta", jwtDTO);
        return ResponseEntity.ok(response);
    }


}
