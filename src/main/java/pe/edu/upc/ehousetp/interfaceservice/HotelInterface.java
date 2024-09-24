package pe.edu.upc.ehousetp.interfaceservice;

import pe.edu.upc.ehousetp.entities.Hotel;

import java.util.List;

public interface HotelInterface {
    public void insert(Hotel hotel);
    public List<Hotel> list();
    public void delete(int idHotel);
    public Hotel listarId(int idHotel);
    //modificar
    public void modificar(Hotel hotel);

    public List<String[]> nmroHabitaciones();
}
