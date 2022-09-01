package equipo10.integrador_v01.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Mapear los atributos de la tabla “categorías” con una clase de nuestro modelo.
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoriaDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private ImagenDTO imagenCategoria;
    @JsonIgnore
    private List<ProductoDTO> productos = new ArrayList<>();

    //ocnstructor sin id y producto
    public CategoriaDTO(String titulo, String descripcion, ImagenDTO imagenCategoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenCategoria = imagenCategoria;
    }
}
