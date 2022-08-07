package equipo10.integrador_v01.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//Mapear los atributos de la tabla “categorías” con una clase de nuestro modelo.
@Entity // El ORM hibernate va a leer esto como bdd
@Table // no especifico el nombre xq quiero que mi bdd se llame Categorias
@Getter
@Setter
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id autoincremental
    private Long id;

    private String titulo;
    private String descripcion;
    private String urlImg;


    //constructores
    public Categorias() {
    }

    public Categorias(String titulo, String descripcion, String urlImg) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
    }

    public Categorias(Long id, String titulo, String descripcion, String urlImg) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
    }
}
