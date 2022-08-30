package equipo10.integrador_v01.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    //@JsonManagedReference
    //@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer"}, allowSetters = true)

    @ManyToMany
    @JoinTable(
            name = "producto_has_politica",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "politica_id"))
    private Set<Politica> politica = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(
            name = "ciudad_id",
            referencedColumnName = "id")
    private Ciudad ciudad;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(
            name = "categoria_id",
            referencedColumnName = "id")
    private Categoria categoria;


    /* Electiva a implementar a futuro
    @OneToMany(mappedBy = "producto")
    private Set<Puntuacion> puntuacion = new HashSet<>();
    */

    //constructor sin id
    public Producto(String titulo, String descripcion, Set<Imagen> imagen, Set<Caracteristica> caracteristica, Set<Politica> politica, Ciudad ciudad, Categoria categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.caracteristica = caracteristica;
        this.politica = politica;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }

}
