package equipo10.integrador_v01.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImagenDTO {

    private Long id;
    private String titulo;
    private String urlImg;
    @JsonIgnore
    private List<ProductoDTO> productos;

    // constructor sin id y prodcutos

    public ImagenDTO(String titulo, String urlImg) {
        this.titulo = titulo;
        this.urlImg = urlImg;
    }
}