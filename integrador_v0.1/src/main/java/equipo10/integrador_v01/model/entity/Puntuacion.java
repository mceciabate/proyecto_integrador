package equipo10.integrador_v01.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PUNTUACION")
@Getter
@Setter
public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PUNTUACION")
    private int puntuacion;

    @ManyToOne
    @JoinColumn(
            name = "PUNTUACION_ID",
            referencedColumnName = "ID",
            nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(
            name = "USUARIO_ID",
            referencedColumnName = "ID",
            nullable = false)
    private Usuario usuario;
}
