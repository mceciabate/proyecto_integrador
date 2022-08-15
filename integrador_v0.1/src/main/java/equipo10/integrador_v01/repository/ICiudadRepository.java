package equipo10.integrador_v01.repository;

import equipo10.integrador_v01.model.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {
}