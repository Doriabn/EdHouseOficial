package pe.edu.upc.ehousetp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ehousetp.entities.Reserva;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    @Query(value = "SELECT u.id,u.nombre,u.apellido,r.id_reserva,r.fecha_reserva, \n" +
            "h.nombre_hotel\n" +
            "FROM usuario u\n" +
            "INNER JOIN reserva r ON u.id = r.usuario_id\n" +
            "INNER JOIN habitacion hab ON r.habitacion_id = hab.id_habitacion\n" +
            "INNER JOIN hotel h ON hab.hotel_id = h.id_hotel", nativeQuery = true)
    public List<String[]> listaReservas();

    @Query(value = "select sum(reserva.precio_total) as total_recaudado\n" +
            "from usuario inner join reserva \n" +
            "on usuario.id = reserva.usuario_id",nativeQuery = true)
    public List<String[]> totalRecaudado();

    @Query(value = "SELECT COUNT(r.id_reserva) AS total_reservas " +
            "FROM reserva r " +
            "WHERE r.fecha_reserva = CURRENT_DATE",
            nativeQuery = true)
    public Long countReservasByFechaReserva();

}
