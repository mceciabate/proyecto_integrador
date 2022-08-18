package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String nombre;
    @Column
    private String icono;

    @ManyToMany(mappedBy = "caracteristica")
    Set<Producto> producto;

}