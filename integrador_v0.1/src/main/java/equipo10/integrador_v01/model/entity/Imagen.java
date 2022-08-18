package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String titulo;
    @Column
    private String urlImg;

    @ManyToMany(mappedBy = "imagen")
    Set<Producto> producto;

    @OneToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Imagen() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}