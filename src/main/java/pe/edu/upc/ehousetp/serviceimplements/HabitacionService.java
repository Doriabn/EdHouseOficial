package pe.edu.upc.ehousetp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ehousetp.entities.Habitacion;
import pe.edu.upc.ehousetp.interfaceservice.HabitacionInterface;
import pe.edu.upc.ehousetp.repositories.HabitacionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HabitacionService implements HabitacionInterface {
    @Autowired
    private HabitacionRepository hR;


    @Override
    public void insert(Habitacion habitacion) {
        hR.save(habitacion);
    }

    @Override
    public List<Habitacion> list() {
        return hR.findAll();
    }

    @Override
    public void delete(int idHabitacion) {
        hR.deleteById(idHabitacion);
    }

    @Override
    public Habitacion listarId(int idHabitacion) {
        return hR.findById(idHabitacion).orElse(new Habitacion());
    }

    @Override
    public void modificar(Habitacion habitacion) {
        hR.save(habitacion);
    }

    @Override
    public Map<String, Long> obtenerCantidadHabitacionesPorTipo(String tipoHabitacion) {
        List<Object[]> resultados = hR.countHabitacionesByTipoHabitacion(tipoHabitacion);
        Map<String, Long> habitacionesPorTipo = new HashMap<>();

        // Transformar los resultados en un Map<String, Long>
        for (Object[] resultado : resultados) {
            String tipo = (String) resultado[0];
            Long totalHabitaciones = ((Number) resultado[1]).longValue();  // Conversión segura a Long
            habitacionesPorTipo.put(tipo, totalHabitaciones);
        }

        return habitacionesPorTipo;
    }

    @Override
    public List<String[]> habitacionFavorita() {
        return hR.habitacionFavorita();
    }


}
