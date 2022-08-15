package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PRODUCTO")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "LATITUD")
    private Double lalitud;
    @Column(name = "LONGITUD")
    private Double longitud;

    @ManyToMany
    @JoinTable(
            name = "PRODUCTO_HAS_IMAGEN",
            joinColumns = @JoinColumn(name = "PRODUCTO_ID"),
            inverseJoinColumns = @JoinColumn(name = "IMAGEN_ID"))
    private Set<Imagen> imagen = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "PRODUCTO_HAS_CARACTERISTICA",
            joinColumns = @JoinColumn(name = "PRODUCTO_ID"),
            inverseJoinColumns = @JoinColumn(name = "CARACTERISTICA_ID"))
    private Set<Caracteristica> caracteristica = new HashSet<>();

    @ManyToOne
    @JoinColumn(
            name = "CIUDAD_ID",
            referencedColumnName = "ID",
            nullable = false)
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(
            name = "CATEGORIA_ID",
            referencedColumnName = "ID",
            nullable = false
    )
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private Set<Puntuacion> puntuacion = new HashSet<>();

}
