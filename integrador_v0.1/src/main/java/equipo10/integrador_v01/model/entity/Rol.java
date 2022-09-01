package equipo10.integrador_v01.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "id",
            nullable = false)
    private Usuario usuario;

    public Rol(String nombre, Usuario usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }
}