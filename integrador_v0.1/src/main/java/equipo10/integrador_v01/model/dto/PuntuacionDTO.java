package equipo10.integrador_v01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PuntuacionDTO {
    private Long id;


    private Integer puntuacion;

    private ProductoDTO producto;

    private UsuarioDTO usuario;

    public PuntuacionDTO(Integer puntuacion, ProductoDTO producto, UsuarioDTO usuario) {
        this.puntuacion = puntuacion;
        this.producto = producto;
        this.usuario = usuario;
    }
}
