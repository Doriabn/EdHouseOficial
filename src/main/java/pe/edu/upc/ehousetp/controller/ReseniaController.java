package pe.edu.upc.ehousetp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ehousetp.dtos.*;
import pe.edu.upc.ehousetp.entities.Resenia;
import pe.edu.upc.ehousetp.interfaceservice.ReseniaInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reseña")
public class ReseniaController {
    @Autowired
    private ReseniaInterface cI;

    @PostMapping("/insert")
    @PreAuthorize("hasAnyAuthority('USUARIO')")
    public void insert(@RequestBody ReseniaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resenia r = m.map(dto, Resenia.class);
        cI.insert(r);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<ReseniaDTO> list() {
        return cI.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ReseniaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('USUARIO')")

    public void delete(@PathVariable int id) {
        cI.delete(id);
    }

    @GetMapping("/listarId/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public ReseniaDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        ReseniaDTO dto = m.map(cI.listarId(id), ReseniaDTO.class);
        return dto;
    }
    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('USUARIO')")

    public void modificar(@RequestBody ReseniaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resenia r = m.map(dto, Resenia.class);
        cI.modificar(r);
    }

    @GetMapping("/habitacion/{idHabitacion}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public ResponseEntity<List<Resenia>> obtenerReseniasPorHabitacion(@PathVariable int idHabitacion) {
        List<Resenia> resenias = cI.obtenerReseniasPorHabitacion(idHabitacion);
        return new ResponseEntity<>(resenias, HttpStatus.OK);
    }

    @GetMapping("/promedioPuntuacion")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public PromPuntuacionDTO promedioPuntuacion() {
        Double promedio = cI.promedioPuntuacion();
        PromPuntuacionDTO dto = new PromPuntuacionDTO();
        dto.setPromPuntuacion(promedio);
        return dto;
    }


}
