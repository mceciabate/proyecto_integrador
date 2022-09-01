package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
//@AllArgsConstructor
//@Getter
@Setter
// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String localidad;
    @Column
    private String provincia;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ciudad")
    private List<Producto> producto = new ArrayList<>();

    // constructor sin id y producto
    public Ciudad(String localidad, String provincia) {
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Ciudad(Long id, String localidad, String provincia, List<Producto> producto) {
        this.id = id;
        this.localidad = localidad;
        this.provincia = provincia;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public List<Producto> getProducto() {
        return producto;
    }
}
