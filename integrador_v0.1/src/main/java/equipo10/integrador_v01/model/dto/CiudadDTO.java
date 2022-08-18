package equipo10.integrador_v01.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CiudadDTO {
    private Long id;
    @NotBlank(message = "debe incluir una localidad")
    private String localidad;
    @NotBlank(message = "debe incluir una provincia")
    private String provincia;

    public CiudadDTO(String localidad, String provincia) {
        this.localidad = localidad;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "CiudadDTO{" +
                "localidad='" + localidad + '\'' +
                '}';
    }
}
