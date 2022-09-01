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
    @JsonIgnore
    private List<ProductoDTO> producto = new ArrayList<>();

    public CiudadDTO(String localidad, String provincia) {
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
