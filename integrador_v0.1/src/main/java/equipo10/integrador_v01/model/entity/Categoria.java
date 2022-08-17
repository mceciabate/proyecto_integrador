package equipo10.integrador_v01.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//Mapear los atributos de la tabla “categorías” con una clase de nuestro modelo.
@Entity // El ORM hibernate va a leer esto como bdd
@Table(name = "CATEGORIA")
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id autoincremental
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "URL_IMG")
    private String urlImg;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "categoria") //la lista de productos se instancia junto con el resto de los atributos.
    private Set<Producto> producto;

    //constructores
    public Categoria() {
    }

    public Categoria(String titulo, String descripcion, String urlImg) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
    }

    public Categoria(Long id, String titulo, String descripcion, String urlImg) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
