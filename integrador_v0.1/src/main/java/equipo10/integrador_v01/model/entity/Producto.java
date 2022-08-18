package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String titulo;
    @Column
    private String descripcion;
    /* A implementar a futuro en el opcional
    @Column(name = "LATITUD")
    private Double lalitud;
    @Column(name = "LONGITUD")
    private Double longitud; 3
    */
    @ManyToMany
    @JoinTable(
            name = "producto_has_imagen",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "imagen_id"))
    private Set<Imagen> imagen = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "producto_has_caracteristica",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id"))
    private Set<Caracteristica> caracteristica = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "producto_has_politica",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "politica_id"))
    private Set<Politica> politica = new HashSet<>();

    @ManyToOne
    @JoinColumn(
            name = "ciudad_id",
            referencedColumnName = "id",
            nullable = false)
    private Ciudad ciudad;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(
            name = "categoria_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Categoria categoria;

    /* Electiva a implementar a futuro
    @OneToMany(mappedBy = "producto")
    private Set<Puntuacion> puntuacion = new HashSet<>();
    */

}
