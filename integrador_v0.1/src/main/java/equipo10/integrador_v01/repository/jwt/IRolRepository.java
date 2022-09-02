package equipo10.integrador_v01.repository.jwt;

import equipo10.integrador_v01.model.entity.jwt.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {
}
