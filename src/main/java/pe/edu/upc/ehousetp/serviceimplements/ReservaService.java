package pe.edu.upc.ehousetp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ehousetp.entities.Reserva;
import pe.edu.upc.ehousetp.interfaceservice.ReservaInterface;
import pe.edu.upc.ehousetp.repositories.ReservaRepository;

import java.util.List;

@Service
public class ReservaService implements ReservaInterface {
    @Autowired
    private ReservaRepository rR;


    @Override
    public void insert(Reserva reserva) {
        rR.save(reserva);
    }

    @Override
    public List<Reserva> list() {
        return rR.findAll();
    }

    @Override
    public void delete(int idReserva) {
        rR.deleteById(idReserva);
    }

    @Override
    public Reserva listarId(int idReserva) {
        return rR.findById(idReserva).orElse(new Reserva());
    }

    @Override
    public void modificar(Reserva reserva) {
        rR.save(reserva);
    }

    @Override
    public List<String[]> listaReservas() {
        return rR.listaReservas();
    }

    @Override
    public List<String[]> totalRecaudado() {
        return rR.totalRecaudado();
    }

    @Override
    public Long countReservasByFechaReserva() {
        return rR.countReservasByFechaReserva();
    }
}
