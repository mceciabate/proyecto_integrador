package equipo10.integrador_v01.model;

import javax.persistence.*;


@Entity // El ORM hibernate va a leer esto como bdd
@Table // no especifico el nombre xq quiero que mi bdd se llame Categorias
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
