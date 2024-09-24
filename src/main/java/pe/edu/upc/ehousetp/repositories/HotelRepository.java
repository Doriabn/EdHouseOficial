package pe.edu.upc.ehousetp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ehousetp.entities.Hotel;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Query(value = "SELECT ho.id_hotel, ho.nombre_hotel, COUNT(h.id_habitacion) as numero_habitaciones\n" +
            "FROM hotel ho\n" +
            "LEFT JOIN habitacion h ON ho.id_hotel = h.hotel_id\n" +
            "GROUP BY ho.id_hotel, ho.nombre_hotel\n" +
            "order by numero_habitaciones desc", nativeQuery = true)
    public List<String[]> nmroHabitaciones();
}
