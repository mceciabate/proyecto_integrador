package equipo10.integrador_v01.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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