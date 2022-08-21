package equipo10.integrador_v01.model.dto;

public class CiudadDTO {
    private Long id;
    private String localidad;
    private String provincia;

    public CiudadDTO(String localidad, String provincia) {
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public CiudadDTO() {
    }
}
