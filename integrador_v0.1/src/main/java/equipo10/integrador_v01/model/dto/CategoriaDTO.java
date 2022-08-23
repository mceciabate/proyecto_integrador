package equipo10.integrador_v01.model.dto;

import equipo10.integrador_v01.model.entity.Imagen;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO {
    private Long id;
    @NotBlank(message = "debe incluir un título")
    private String titulo;
    @NotBlank(message = "debe incluir una descripción")
    private String descripcion;
    private Imagen imagenCategoria;

    public CategoriaDTO(String titulo, String descripcion, Imagen imagenCategoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenCategoria = imagenCategoria;
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}