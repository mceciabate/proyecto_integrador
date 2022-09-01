package equipo10.integrador_v01.model.dto;

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

    private List<PuntuacionDTO> puntuacion = new ArrayList<>();

    //constructor sin id ni puntuación list
    public UsuarioDTO(String nombre, String apellido, String email, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
    }
}