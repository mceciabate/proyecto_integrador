package equipo10.integrador_v01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaracteristicaDTO {

    private Long id;
    private String nombre;
    private String icono;
    private String valor;

    /*
    @JsonIgnore
    @ManyToMany(mappedBy = "caracteristica")
    Set<Producto> productos = new HashSet<>();
    */

    public CaracteristicaDTO(String nombre, String icono, String valor) {
        this.nombre = nombre;
        this.icono = icono;
        this.valor = valor;
    }
}