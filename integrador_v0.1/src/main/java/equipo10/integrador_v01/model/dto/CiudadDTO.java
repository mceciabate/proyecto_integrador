package equipo10.integrador_v01.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CiudadDTO {

    private Long id;
    private String localidad;
    private String provincia;
    private String direccion;
    @JsonIgnore
    private List<ProductoDTO> producto = new ArrayList<>();

    public CiudadDTO(String localidad, String provincia, String direccion) {
        this.localidad = localidad;
        this.provincia = provincia;
        this.direccion = direccion;
    }
}
