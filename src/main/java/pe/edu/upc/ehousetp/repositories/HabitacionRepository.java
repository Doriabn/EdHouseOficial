package pe.edu.upc.ehousetp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ehousetp.entities.Habitacion;

import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    @Query(value = "SELECT h.tipohabitacon, COUNT(h.id_habitacion) AS total_habitaciones " +
            "FROM habitacion h " +
            "WHERE h.tipohabitacon = :tipoHabitacion " +
            "GROUP BY h.tipohabitacon",
            nativeQuery = true)
    List<Object[]> countHabitacionesByTipoHabitacion(@Param("tipoHabitacion") String tipoHabitacion);

    @Query(value = "select ho.id_hotel,ho.nombre_hotel, h.tipohabitacion, count(r.id_reserva) as hab_favorita\n" +
            "from habitacion h\n" +
            "inner join hotel ho on h.hotel_id = ho.id_hotel\n" +
            "inner join reserva r on h.id_habitacion = r.habitacion_id\n" +
            "group by ho.id_hotel, h.tipohabitacion,ho.nombre_hotel\n" +
            "order by hab_favorita desc", nativeQuery = true)
    public List<String[]> habitacionFavorita();
}
