package equipo10.integrador_v01.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaDTO {
    private Long id;
    @NotBlank(message = "debe incluir un título")
    private String titulo;
    @NotBlank(message = "debe incluir una descripción")
    private String descripcion;
    private String urlImg;

    public CategoriaDTO(String titulo, String descripcion, String urlImg) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public CategoriaDTO() {
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}