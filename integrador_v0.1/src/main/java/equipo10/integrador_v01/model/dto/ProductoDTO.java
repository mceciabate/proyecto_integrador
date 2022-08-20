package equipo10.integrador_v01.model.dto;

import equipo10.integrador_v01.model.entity.Caracteristica;
import equipo10.integrador_v01.model.entity.Categoria;
import equipo10.integrador_v01.model.entity.Ciudad;
import equipo10.integrador_v01.model.entity.Politica;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ProductoDTO {
    private Long id;

    @NotBlank(message = "debe incluir un título")
    private String titulo;

    @NotBlank(message = "debe incluir una descripcion")
    private String descripcion;

    @NotBlank(message = "debe incluir caracteristica")
    private Set<Caracteristica> caracteristicas;

    private Set<Politica> politicas;

    @NotBlank(message = "debe incluir una ciudad")
    private Ciudad ciudad;



    //@NotBlank(message = "debe incluir una categoria")
    private Categoria categoria;

    /* Electiva a implementar a futuro
    @NotBlank(message = "debe incluir una puntuacion")
    private Set<Puntuacion> puntuacion;
    */

    //constructores
    public ProductoDTO() {
    }

    public ProductoDTO(String titulo, String descripcion, Set<Caracteristica> caracteristicas, Set<Politica> politicas, Ciudad ciudad, Categoria categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.politicas = politicas;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }

    public ProductoDTO(Long id, String titulo, String descripcion, Set<Caracteristica> caracteristicas, Set<Politica> politicas, Ciudad ciudad, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.politicas = politicas;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }

    public ProductoDTO(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
}
