package equipo10.integrador_v01.repository;

import equipo10.integrador_v01.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //le aviso que voy a usar el repo de hibernate en la tabla de categorias
public interface ICategoriasRepository extends JpaRepository<Categorias, Long> {
}
