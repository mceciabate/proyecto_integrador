package equipo10.integrador_v01.repository.jwt;

import equipo10.integrador_v01.model.jwt.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
   //Usuario buscarporEmail(String email);
}