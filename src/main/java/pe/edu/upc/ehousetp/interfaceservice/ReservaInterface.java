package pe.edu.upc.ehousetp.interfaceservice;

import pe.edu.upc.ehousetp.entities.Reserva;

import java.util.List;

public interface ReservaInterface {
    public void insert(Reserva reserva);
    public List<Reserva> list();
    public void delete(int idReserva);
    public Reserva listarId(int idReserva);
    //modificar
    public void modificar(Reserva reserva);

    public List<String[]> listaReservas();

    public List<String[]> totalRecaudado();

    public Long countReservasByFechaReserva();
}
