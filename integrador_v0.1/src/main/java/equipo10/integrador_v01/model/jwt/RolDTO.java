package equipo10.integrador_v01.model.jwt;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RolDTO {
    private Long id;
    private String nombre;

    public RolDTO(String nombre) {
        this.nombre = nombre;
    }
}