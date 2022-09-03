package equipo10.integrador_v01.repository.jwt;

import equipo10.integrador_v01.model.jwt.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

   // Creamos una query para buscar al usuario por email (su username)
   @Query("from Usuario u where u.email =:email")
   Optional<Usuario> findByUsername(@Param("email") String email);
}