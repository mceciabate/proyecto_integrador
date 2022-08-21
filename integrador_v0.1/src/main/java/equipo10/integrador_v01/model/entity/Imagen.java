package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity @Getter  @Setter
@Table(name = "IMAGEN")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="TITULO")
    private String titulo;
    @Column(name="URL")
    private String urlImg;

    @ManyToMany(fetch=FetchType.EAGER, mappedBy = "imagen")
    @JsonIgnore
    private Set<Producto> productos;

    public Imagen() {
    }

    public Imagen(String titulo, String urlImg, Set<Producto> productos) {
        this.titulo = titulo;
        this.urlImg = urlImg;
        this.productos = productos;
    }

    public Imagen(String titulo, String urlImg) {
        this.titulo = titulo;
        this.urlImg = urlImg;
    }
}