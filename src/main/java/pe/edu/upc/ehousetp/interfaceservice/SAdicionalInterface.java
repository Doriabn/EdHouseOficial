package pe.edu.upc.ehousetp.interfaceservice;

import pe.edu.upc.ehousetp.entities.ServiciosAdicionales;

import java.util.List;

public interface SAdicionalInterface {
    public void insert(ServiciosAdicionales servAdicional);
    public List<ServiciosAdicionales> list();
    public void delete(int idServAdicional);
    public ServiciosAdicionales listarId(int idServAdicional);
    //modificar
    public void modificar(ServiciosAdicionales servAdicional);
}
