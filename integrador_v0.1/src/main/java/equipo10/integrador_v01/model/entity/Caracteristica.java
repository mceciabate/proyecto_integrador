package equipo10.integrador_v01.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "CARACTERISTICA")
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private Integer nombre;
    @Column(name = "ICONO")
    private Integer icono;

    @ManyToMany(mappedBy = "caracteristica")
    private Set<Producto> producto;


    public Caracteristica() {
    }
}