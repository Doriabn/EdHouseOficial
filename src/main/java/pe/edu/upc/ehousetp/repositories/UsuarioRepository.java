package pe.edu.upc.ehousetp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ehousetp.entities.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
 public Usuario findOneByUsername(String username);
}
