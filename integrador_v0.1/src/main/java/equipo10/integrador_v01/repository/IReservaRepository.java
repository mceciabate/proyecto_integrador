package equipo10.integrador_v01.repository;

import equipo10.integrador_v01.model.dto.ReservaDTO;
import equipo10.integrador_v01.model.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long> {
/*
    @Query("SELECT b DISTINCT FROM Reserva b WHERE b.fecha_recogida = ?1 AND b.fecha_entrega = ?2")
    List<ReservaDTO> encontrarDisponiblesPorFecha (LocalDate fechaRecogida, LocalDate fechaEntrega);
*/
}
