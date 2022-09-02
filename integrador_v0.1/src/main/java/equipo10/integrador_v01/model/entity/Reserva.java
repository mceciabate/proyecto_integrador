package equipo10.integrador_v01.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import equipo10.integrador_v01.model.entity.jwt.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String horaInicio;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaRecogida;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaEntrega;

    @ManyToOne
    @JoinColumn(
            name = "producto_id",
            referencedColumnName = "id",
            nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "id",
            nullable = false)
    private Usuario usuario;

    public Reserva(String horaInicio, Date fechaRecogida, Date fechaEntrega, Producto producto, Usuario usuario) {
        this.horaInicio = horaInicio;
        this.fechaRecogida = fechaRecogida;
        this.fechaEntrega = fechaEntrega;
        this.producto = producto;
        this.usuario = usuario;
    }
}
