package equipo10.integrador_v01.model.dto;

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

    public ReservaDTO(String horaInicio, LocalDate fechaRecogida, LocalDate fechaEntrega) {
        this.horaInicio = horaInicio;
        this.fechaRecogida = fechaRecogida;
        this.fechaEntrega = fechaEntrega;
    }
}
