package pe.edu.upc.ehousetp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ehousetp.dtos.HabitacionFavoritaDTO;
import pe.edu.upc.ehousetp.dtos.HotelDTO;
import pe.edu.upc.ehousetp.dtos.NroHabitacionesDTO;
import pe.edu.upc.ehousetp.entities.Hotel;
import pe.edu.upc.ehousetp.interfaceservice.HotelInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelInterface mI;

    @PostMapping("/insert")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void insert(@RequestBody HotelDTO dto) {
        ModelMapper m = new ModelMapper();
        Hotel t = m.map(dto, Hotel.class);
        mI.insert(t);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<HotelDTO> list() {
        return mI.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, HotelDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void delete(@PathVariable int id) {
        mI.delete(id);
    }

    @GetMapping("/listarId/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public HotelDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        HotelDTO dto = m.map(mI.listarId(id), HotelDTO.class);
        return dto;
    }
    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody HotelDTO dto) {
        ModelMapper m = new ModelMapper();
        Hotel t = m.map(dto, Hotel.class);
        mI.modificar(t);
    }

    @GetMapping("/nmroHabitaciones")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<NroHabitacionesDTO> nmroHabitaciones() {
        List<String[]> lista = mI.nmroHabitaciones();
        List<NroHabitacionesDTO> listaDTO = new java.util.ArrayList<>();
        for (String[] columna : lista) {
            NroHabitacionesDTO dto = new NroHabitacionesDTO();
            dto.setIdHotel(Integer.parseInt(columna[0]));
            dto.setNombreHotel(columna[1]);
            dto.setNroHabitaciones(Integer.parseInt(columna[2]));


        }
        return listaDTO;
    }

}
