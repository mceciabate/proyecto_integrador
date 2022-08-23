package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Politica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
  //  @JsonBackReference
  //  @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToMany(mappedBy = "politica")
    private Set<Producto> producto;

}
