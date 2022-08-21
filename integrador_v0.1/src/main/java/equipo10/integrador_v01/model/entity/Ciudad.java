package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "CIUDAD")
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
    @JsonIgnore
    private Set<Producto> producto;

    public Ciudad() {
    }

    @Override
    public String toString() {
        return "Ciudad: " +
                "id=" + id +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", producto=" + producto +
                '}';
    }
}
