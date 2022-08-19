package equipo10.integrador_v01.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ImagenDTO {
    private Long id;
    @NotBlank(message = "debe incluir un titulo")
    private String titulo;
    @NotBlank(message = "debe incluir una url")
    private String urlImg;

    public ImagenDTO(String titulo, String urlImg) {
        this.titulo = titulo;
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "ImagenDTO{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
