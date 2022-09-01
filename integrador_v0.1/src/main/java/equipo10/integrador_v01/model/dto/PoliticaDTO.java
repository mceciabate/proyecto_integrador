package equipo10.integrador_v01.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PoliticaDTO {

    private Long id;
    private String titulo;
    private String descripcion;

    //  @JsonBackReference
    //  @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, allowSetters = true)
    /*
    @JsonIgnore
    @ManyToMany(mappedBy = "politica")
    private Set<Producto> producto;
    */

    public PoliticaDTO(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
}
