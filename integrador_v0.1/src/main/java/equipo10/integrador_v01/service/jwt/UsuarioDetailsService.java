package equipo10.integrador_v01.service.jwt;

import equipo10.integrador_v01.model.jwt.Usuario;
import equipo10.integrador_v01.model.jwt.UsuarioAuth;
import equipo10.integrador_v01.model.jwt.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {
    @Autowired
    IUsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioDTO usuario = usuarioService.buscarUsuarioPorEmail(username);
        return UsuarioAuth.build(usuario);
    }
}
