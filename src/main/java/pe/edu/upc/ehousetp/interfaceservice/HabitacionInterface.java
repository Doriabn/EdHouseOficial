package pe.edu.upc.ehousetp.interfaceservice;

import pe.edu.upc.ehousetp.entities.Habitacion;

import java.util.List;
import java.util.Map;

public interface HabitacionInterface {
    public void insert(Habitacion habitacion);
    public List<Habitacion> list();
    public void delete(int idHabitacion);
    public Habitacion listarId(int idHabitacion);
    //modificar
    public void modificar(Habitacion habitacion);

    Map<String, Long> obtenerCantidadHabitacionesPorTipo(String tipoHabitacion);
    public List<String[]> habitacionFavorita();
}
