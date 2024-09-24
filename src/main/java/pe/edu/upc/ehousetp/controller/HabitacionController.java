package pe.edu.upc.ehousetp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ehousetp.dtos.HabitacionDTO;
import pe.edu.upc.ehousetp.dtos.HabitacionFavoritaDTO;
import pe.edu.upc.ehousetp.entities.Habitacion;
import pe.edu.upc.ehousetp.interfaceservice.HabitacionInterface;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {
    @Autowired
    private HabitacionInterface hI;

    @PostMapping("/insert")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void insert(@RequestBody HabitacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Habitacion h = m.map(dto, Habitacion.class);
        hI.insert(h);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<HabitacionDTO> list() {
        return hI.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, HabitacionDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void delete(@PathVariable int id) {
        hI.delete(id);
    }

    @GetMapping("/listarId/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public HabitacionDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        HabitacionDTO dto = m.map(hI.listarId(id), HabitacionDTO.class);
        return dto;
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody HabitacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Habitacion h = m.map(dto, Habitacion.class);
        hI.modificar(h);
    }

    @GetMapping("/cantidadTipo")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public Map<String, Long> getCantidadHabitacionesPorTipo(@RequestParam String tipoHabitacion) {
        return hI.obtenerCantidadHabitacionesPorTipo(tipoHabitacion);
    }

    @GetMapping("/preferenciahabitacion")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<HabitacionFavoritaDTO> habitacionFavorita() {
        List<String[]> lista = hI.habitacionFavorita();
        List<HabitacionFavoritaDTO> listaDTO = new java.util.ArrayList<>();
        for (String[] columna : lista) {
            HabitacionFavoritaDTO dto = new HabitacionFavoritaDTO();
            dto.setIdHotel(Integer.parseInt(columna[0]));
            dto.setNombreHotel(columna[1]);
            dto.setTipoHabitacion(columna[2]);
            dto.setIdHabitacionFavorita(Integer.parseInt(columna[3]));

        }
        return listaDTO;
    }
}
