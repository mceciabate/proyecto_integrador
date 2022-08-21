package equipo10.integrador_v01.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CaracteristicaDTO {
    private Long id;
    @NotBlank(message = "debe incluir un nombre")
    private String nombre;
    private Integer icono;

    public CaracteristicaDTO(String nombre, Integer icono) {
        this.nombre = nombre;
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "CaracteristicaDTO{" +
                "nombre=" + nombre +
                '}';
    }
}
