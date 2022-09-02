package equipo10.integrador_v01.model.dto.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import equipo10.integrador_v01.model.dto.PuntuacionDTO;
import equipo10.integrador_v01.model.entity.jwt.Rol;
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
    @JsonIgnore
    private List<PuntuacionDTO> puntuacion = new ArrayList<>();

    private Rol rol;
    //constructor sin id ni puntuación list
    public UsuarioDTO(String nombre, String apellido, String email, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
    }
}