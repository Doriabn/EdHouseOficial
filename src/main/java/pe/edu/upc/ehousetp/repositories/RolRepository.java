package pe.edu.upc.ehousetp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ehousetp.entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
