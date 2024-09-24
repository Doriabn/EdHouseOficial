package pe.edu.upc.ehousetp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ehousetp.entities.Hotel;
import pe.edu.upc.ehousetp.interfaceservice.HotelInterface;
import pe.edu.upc.ehousetp.repositories.HotelRepository;

import java.util.List;

@Service
public class HotelService implements HotelInterface {
    @Autowired
    private HotelRepository hR;

    @Override
    public void insert(Hotel hotel) {
        hR.save(hotel);
    }

    @Override
    public List<Hotel> list() {
        return hR.findAll();
    }

    @Override
    public void delete(int idHotel) {
        hR.deleteById(idHotel);
    }

    @Override
    public Hotel listarId(int idHotel) {
        return hR.findById(idHotel).orElse(new Hotel());
    }

    @Override
    public void modificar(Hotel hotel) {
        hR.save(hotel);
    }

    @Override
    public List<String[]> nmroHabitaciones() {
        return hR.nmroHabitaciones();
    }


}
