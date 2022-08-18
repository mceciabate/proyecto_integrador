package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "CIUDAD")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CIUDAD")
    private String localidad;
    @Column(name = "PROVINCIA")
    private String provincia;

    @OneToMany(mappedBy = "ciudad")
    private Set<Producto> producto;

}
