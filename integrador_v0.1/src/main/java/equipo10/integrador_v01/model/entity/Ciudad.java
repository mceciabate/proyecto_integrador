package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String localidad;
    @Column
    private String provincia;

    @OneToMany(mappedBy = "ciudad", fetch = FetchType.LAZY)
    private Set<Producto> producto = new HashSet<>();

    public Ciudad() {
    }

    public Ciudad(Long id, String localidad, String provincia) {
        this.id = id;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Ciudad(String localidad, String provincia) {
        this.localidad = localidad;
        this.provincia = provincia;
    }


}
