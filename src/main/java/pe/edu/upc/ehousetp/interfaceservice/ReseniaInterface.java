package pe.edu.upc.ehousetp.interfaceservice;

import pe.edu.upc.ehousetp.entities.Resenia;

import java.util.List;

public interface ReseniaInterface {
    public void insert(Resenia resenia);
    public List<Resenia> list();
    public void delete(int idResenia);
    public Resenia listarId(int idResenia);
    //modificar
    public void modificar(Resenia resenia);

    List<Resenia> obtenerReseniasPorHabitacion(int idHabitacion);

    public Double promedioPuntuacion();
}
