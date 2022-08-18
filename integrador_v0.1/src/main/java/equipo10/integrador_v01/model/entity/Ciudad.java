package equipo10.integrador_v01.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String localidad;
    @Column
    private String provincia;

    @OneToMany(mappedBy = "ciudad")
    private Set<Producto> producto;

}
