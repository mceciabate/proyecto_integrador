package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column
    private String direccion;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ciudad")
    private List<Producto> producto = new ArrayList<>();

    // constructor sin id y producto
    public Ciudad(String localidad, String provincia, String direccion) {
        this.localidad = localidad;
        this.provincia = provincia;
        this.direccion = direccion;
    }

    public Ciudad(Long id, String localidad, String provincia, String direccion, List<Producto> producto) {
        this.id = id;
        this.localidad = localidad;
        this.provincia = provincia;
        this.producto = producto;
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public List<Producto> getProducto() {
        return producto;
    }
}
