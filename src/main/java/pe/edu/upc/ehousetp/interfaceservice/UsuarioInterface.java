package pe.edu.upc.ehousetp.interfaceservice;

import pe.edu.upc.ehousetp.entities.Usuario;

import java.util.List;

public interface UsuarioInterface {
    public void insert(Usuario usuario);
    public List<Usuario> list();
    public void delete(int idUsuario);
    public Usuario listarId(int idUsuario);
    //modificar
    public void modificar(Usuario usuario);
}
