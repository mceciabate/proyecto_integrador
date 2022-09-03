package equipo10.integrador_v01.model.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import equipo10.integrador_v01.model.dto.PuntuacionDTO;
import equipo10.integrador_v01.model.jwt.Rol;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
    private RolDTO rol;

    @JsonIgnore
    private List<PuntuacionDTO> puntuacion = new ArrayList<>();

    //constructor sin id ni puntuación list
    public UsuarioDTO(String nombre, String apellido, String email, String contrasenia, RolDTO rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }
    // el test no me reconoce la anotacion de lombok, necesito un constructor con todos los args, set y get de rol
    public UsuarioDTO(Long id, String nombre, String apellido, String email, String contrasenia, RolDTO rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }
    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }


}