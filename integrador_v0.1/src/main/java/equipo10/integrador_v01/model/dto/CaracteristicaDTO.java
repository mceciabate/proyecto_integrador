package equipo10.integrador_v01.model.dto;

public class CaracteristicaDTO {
    private Long id;
    private Integer nombre;
    private Integer icono;

    public CaracteristicaDTO(Integer nombre, Integer icono) {
        this.nombre = nombre;
        this.icono = icono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public Integer getIcono() {
        return icono;
    }

    public void setIcono(Integer icono) {
        this.icono = icono;
    }
}
