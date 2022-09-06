package equipo10.integrador_v01.repository;

import equipo10.integrador_v01.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository //le aviso que voy a usar el repo de hibernate en la tabla de categorias
public interface IProductoRepository extends JpaRepository<Producto, Long> {


    @Query(value = "SELECT * FROM producto p LEFT JOIN reserva r ON p.id = r.producto_id AND fecha_inicio <= ?1 AND fecha_fin >= ?2 WHERE p.ciudad_id = ?3 AND r.producto_id IS NULL", nativeQuery = true)
    List<Producto> productoDisponiblePorFechaYCiudad (LocalDate fechaRecogidaInicio, LocalDate fechaEntregaFin, Long ciudadId);

/*
    @Query("SELECT p FROM producto where ciudad_id = ?1 and id not in (SELECT producto_id FROM reserva r where fecha_entrega <= ?2 and fecha_recogida >= ?3)")
    List<Producto> productoDisponiblePorFechaYCiudad (LocalDate fechaRecogidaInicio, LocalDate fechaEntregaFin, Long ciudadId);*/

}