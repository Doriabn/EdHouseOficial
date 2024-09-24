package pe.edu.upc.ehousetp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ehousetp.entities.Resenia;
import pe.edu.upc.ehousetp.interfaceservice.ReseniaInterface;
import pe.edu.upc.ehousetp.repositories.ReseniaRepository;

import java.util.List;
@Service
public class ReseniaService implements ReseniaInterface {
    @Autowired
    private ReseniaRepository rR;


    @Override
    public void insert(Resenia resenia) {
        rR.save(resenia);
    }

    @Override
    public List<Resenia> list() {
        return rR.findAll();
    }

    @Override
    public void delete(int idResenia) {
        rR.deleteById(idResenia);
    }

    @Override
    public Resenia listarId(int idResenia) {
        return rR.findById(idResenia).orElse(new Resenia());
    }

    @Override
    public void modificar(Resenia resenia) {
        rR.save(resenia);
    }

    @Override
    public List<Resenia> obtenerReseniasPorHabitacion(int idHabitacion) {
        return rR.findReseniasByHabitacionId(idHabitacion);
    }

    @Override
    public Double promedioPuntuacion() {
        return rR.promedioPuntuacion();
    }


}
