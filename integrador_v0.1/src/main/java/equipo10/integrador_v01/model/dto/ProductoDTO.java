package equipo10.integrador_v01.model.dto;

import lombok.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private List<ImagenDTO> imagen = new ArrayList<>();
    private List<CaracteristicaDTO> caracteristica = new ArrayList<>();
    //@JsonManagedReference
    //@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer"}, allowSetters = true)
    private List<PoliticaDTO> politica = new ArrayList<>();
    private CiudadDTO ciudad;
    private CategoriaDTO categoria;

    //Constructor sin id


    public ProductoDTO(String titulo, String descripcion, List<ImagenDTO> imagen, List<CaracteristicaDTO> caracteristica, List<PoliticaDTO> politica, CiudadDTO ciudad, CategoriaDTO categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.caracteristica = caracteristica;
        this.politica = politica;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }
}
