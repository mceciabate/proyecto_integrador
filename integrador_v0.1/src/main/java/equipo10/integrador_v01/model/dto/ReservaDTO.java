package equipo10.integrador_v01.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import equipo10.integrador_v01.model.entity.Producto;
import equipo10.integrador_v01.model.entity.Usuario;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservaDTO {
    private Long id;
    private String horaInicio;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaFin;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaInicio;
    private Producto producto;
    private Usuario usuario;

    public ReservaDTO(String horaInicio, LocalDate fechaRecogidaInicio, LocalDate fechaInicio, Producto producto, Usuario usuario) {
        this.horaInicio = horaInicio;
        this.fechaFin = fechaRecogidaInicio;
        this.fechaInicio = fechaInicio;
        this.producto = producto;
        this.usuario = usuario;
    }
}
