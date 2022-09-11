package equipo10.integrador_v01.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import equipo10.integrador_v01.model.jwt.UsuarioDTO;
import equipo10.integrador_v01.model.dto.ProductoDTO;
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
    private ProductoDTO producto;
    private UsuarioDTO usuario;

    public ReservaDTO(String horaInicio, LocalDate fechaRecogidaInicio, LocalDate fechaInicio, ProductoDTO producto, UsuarioDTO usuario) {
        this.horaInicio = horaInicio;
        this.fechaFin = fechaRecogidaInicio;
        this.fechaInicio = fechaInicio;
        this.producto = producto;
        this.usuario = usuario;
    }
}
