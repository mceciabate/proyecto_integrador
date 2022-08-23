package equipo10.integrador_v01.model.dto;

import equipo10.integrador_v01.model.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO {
    private Long id;

    @NotBlank(message = "debe incluir un título")
    private String titulo;

    @NotBlank(message = "debe incluir una descripcion")
    private String descripcion;

    @NotBlank(message = "debe incluir una imagen")
    private Set<Imagen> imagen;

    @NotBlank(message = "debe incluir caracteristica")
    private Set<Caracteristica> caracteristica;

    @NotBlank(message = "debe incluir politicas")
    private Set<Politica> politica;

    @NotBlank(message = "debe incluir una ciudad")
    private Ciudad ciudad;

    @NotBlank(message = "debe incluir una categoria")
    private Categoria categoria;

    /* Electiva a implementar a futuro
    @NotBlank(message = "debe incluir una puntuacion")
    private Set<Puntuacion> puntuacion;
    */

    //constructores




    public ProductoDTO(String titulo, String descripcion, Set<Imagen> imagen, Set<Caracteristica> caracteristica, Set<Politica> politica, Ciudad ciudad, Categoria categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.caracteristica = caracteristica;
        this.politica = politica;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }

    public ProductoDTO(Long id, String titulo, String descripcion, Set<Imagen> imagen, Set<Caracteristica> caracteristica, Set<Politica> politica, Ciudad ciudad, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.caracteristica = caracteristica;
        this.politica = politica;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
