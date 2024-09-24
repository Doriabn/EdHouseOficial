package pe.edu.upc.ehousetp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ehousetp.entities.ServiciosAdicionales;
import pe.edu.upc.ehousetp.interfaceservice.SAdicionalInterface;
import pe.edu.upc.ehousetp.repositories.SAdicionalRepository;

import java.util.List;

@Service
public class SAdicionalService implements SAdicionalInterface {
    @Autowired
    private SAdicionalRepository sR;

    @Override
    public void insert(ServiciosAdicionales servAdicional) {
        sR.save(servAdicional);
    }

    @Override
    public List<ServiciosAdicionales> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int idServAdicional) {
        sR.deleteById(idServAdicional);
    }

    @Override
    public ServiciosAdicionales listarId(int idServAdicional) {
        return sR.findById(idServAdicional).orElse(new ServiciosAdicionales());
    }

    @Override
    public void modificar(ServiciosAdicionales servAdicional) {
        sR.save(servAdicional);
    }
}
