package equipo10.integrador_v01.repository.jwt;

import equipo10.integrador_v01.model.entity.jwt.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario buscarporEmail(String email);
}
