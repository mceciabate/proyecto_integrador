package equipo10.integrador_v01.model.dto;

import equipo10.integrador_v01.model.entity.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class ProductoDTO {
    private Long id;
    @NotBlank(message = "debe incluir el título")
    private String titulo;
    @NotBlank(message= "debe incluir una descripcion")
    private String descripcion;
    @NotBlank (message= "debe incluir una categoria")
    private Categoria categoria;

    public ProductoDTO(String titulo, String descripcion, Categoria categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
