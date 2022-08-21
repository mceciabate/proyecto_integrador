package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCTO")
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    /* A implementar a futuro en el opcional
    @Column(name = "LATITUD")
    private Double lalitud;
    @Column(name = "LONGITUD")
    private Double longitud; 3
    */

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "PRODUCTO_HAS_IMAGEN",
            joinColumns = @JoinColumn(name = "PRODUCTO_ID"),
            inverseJoinColumns = @JoinColumn(name = "IMAGEN_ID"))
    @JsonIgnore
    private Set<Imagen> imagen = new HashSet<>();

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "PRODUCTO_HAS_CARACTERISTICA",
            joinColumns = @JoinColumn(name = "PRODUCTO_ID"),
            inverseJoinColumns = @JoinColumn(name = "CARACTERISTICA_ID"))
    @JsonIgnore
    private Set<Caracteristica> caracteristica = new HashSet<>();

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(
            name = "CIUDAD_ID",
            referencedColumnName = "ID",
            nullable = false)
    private Ciudad ciudad;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(
            name = "CATEGORIA_ID",
            referencedColumnName = "ID",
            nullable = false
    )
    private Categoria categoria;

    /* Electiva a implementar a futuro
    @OneToMany(mappedBy = "producto")
    private Set<Puntuacion> puntuacion = new HashSet<>();
    */

    public Producto() {
    }

    public Producto(String titulo, String descripcion, Set<Imagen> imagen, Set<Caracteristica> caracteristica, Ciudad ciudad, Categoria categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.caracteristica = caracteristica;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }

    public Producto(Long id, String titulo, String descripcion, Set<Imagen> imagen, Set<Caracteristica> caracteristica, Ciudad ciudad, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.caracteristica = caracteristica;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }
}
