package equipo10.integrador_v01.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PoliticaDTO {
    private Long id;
    private String titulo;
    private String descripcion;

    @Override
    public String toString() {
        return "PoliticaDTO{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
