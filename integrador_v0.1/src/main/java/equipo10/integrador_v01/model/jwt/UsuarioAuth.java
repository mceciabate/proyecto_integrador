package equipo10.integrador_v01.model.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioAuth implements UserDetails {
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
    private Collection<? extends GrantedAuthority> authorities;

    public static UsuarioAuth build(UsuarioDTO usuarioDTO) {
        List<GrantedAuthority> authoritiesU = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(usuarioDTO.getRol().getNombre());
        authoritiesU.add(authority);
        return new UsuarioAuth(usuarioDTO.getNombre(),
                usuarioDTO.getApellido(),
                usuarioDTO.getEmail(),
                usuarioDTO.getContrasenia(),
                authoritiesU);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return contrasenia;
    }

    @Override
    public String getUsername() {
        return email;
    }

    //"message": "User account has expired",
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //"message": "User account is locked",
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //"message": "User account has expired",
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //"message": "User is disabled",
    @Override
    public boolean isEnabled() {
        return true;
    }
}
