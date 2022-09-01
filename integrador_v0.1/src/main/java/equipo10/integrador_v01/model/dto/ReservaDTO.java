package equipo10.integrador_v01.model.dto;

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
    private LocalDate fechaRecogida;
    private LocalDate fechaEntrega;
    private Producto producto;
    private Usuario usuario;

    public ReservaDTO(String horaInicio, LocalDate fechaRecogida, LocalDate fechaEntrega, Producto producto, Usuario usuario) {
        this.horaInicio = horaInicio;
        this.fechaRecogida = fechaRecogida;
        this.fechaEntrega = fechaEntrega;
        this.producto = producto;
        this.usuario = usuario;
    }
}
