package pe.edu.upc.ehousetp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ehousetp.entities.Usuario;
import pe.edu.upc.ehousetp.interfaceservice.UsuarioInterface;
import pe.edu.upc.ehousetp.repositories.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService implements UsuarioInterface {
    @Autowired
    private UsuarioRepository uR;

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int idUsuario) {
        uR.deleteById(idUsuario);

    }

    @Override
    public Usuario listarId(int idUsuario) {
        return uR.findById(idUsuario).orElse(new Usuario());
    }

    @Override
    public void modificar(Usuario usuario) {
        uR.save(usuario);
    }
}
