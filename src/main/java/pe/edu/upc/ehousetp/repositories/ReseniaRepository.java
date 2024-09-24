package pe.edu.upc.ehousetp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ehousetp.entities.Resenia;

import java.util.List;

@Repository
public interface ReseniaRepository extends JpaRepository<Resenia, Integer> {
    @Query("SELECT r FROM Resenia r WHERE r.habitacion.idHabitacion = :idHabitacion")
    List<Resenia> findReseniasByHabitacionId(@Param("idHabitacion") int idHabitacion);

    @Query(value = "SELECT AVG(puntuacion) as " +
            "prom_puntuacion FROM resenia", nativeQuery = true)

    public Double promedioPuntuacion();
}
