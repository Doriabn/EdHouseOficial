package pe.edu.upc.ehousetp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ehousetp.entities.Rol;
import pe.edu.upc.ehousetp.interfaceservice.RolInterfaces;
import pe.edu.upc.ehousetp.repositories.RolRepository;

import java.util.List;

@Service
public class RolService implements RolInterfaces {
    @Autowired
    private RolRepository lR;

    @Override
    public void insert(Rol rol) {
        lR.save(rol);
    }

    @Override
    public List<Rol> list() {
        return lR.findAll();
    }

    @Override
    public void delete(Long idRol) {
        lR.deleteById(idRol);

    }

    @Override
    public Rol listarId(Long idRol) {
        return lR.findById(idRol).orElse(new Rol());
    }

    @Override
    public void modificar(Rol rol) {
        lR.save(rol);
    }
}
