package equipo10.integrador_v01.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nombre;
    @Column
    private String icono;
    @Column
    private String valor;

    /*
    @JsonIgnore
    @ManyToMany(mappedBy = "caracteristica")
    Set<Producto> productos = new HashSet<>();
    */

    public Caracteristica(String nombre, String icono, String valor) {
        this.nombre = nombre;
        this.icono = icono;
        this.valor = valor;
    }
}