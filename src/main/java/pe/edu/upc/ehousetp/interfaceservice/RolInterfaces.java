package pe.edu.upc.ehousetp.interfaceservice;

import pe.edu.upc.ehousetp.entities.Rol;

import java.util.List;

public interface RolInterfaces {
 //insertar un rol
    public void insert(Rol rol);
    //listar todos los roles
    public List<Rol> list();
    //eliminar un rol
    public void delete(Long idRol);
    //listar un rol por id
    public Rol listarId(Long idRol);
   //modificar
   public void modificar(Rol rol);
}
