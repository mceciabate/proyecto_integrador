package equipo10.integrador_v01.model.dto;

import javax.persistence.Column;

public class ImagenDTO {
    private Long id;
    private String titulo;
    private String urlImg;

    public ImagenDTO(String titulo, String urlImg) {
        this.titulo = titulo;
        this.urlImg = urlImg;
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

    public ImagenDTO() {
    }
}
