package pe.edu.upc.ehousetp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ehousetp.dtos.SAdicionalDTO;
import pe.edu.upc.ehousetp.entities.ServiciosAdicionales;
import pe.edu.upc.ehousetp.interfaceservice.SAdicionalInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servadicional")
public class SAdicionalController {
    @Autowired
    private SAdicionalInterface sI;

    @PostMapping("/insert")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void insert(@RequestBody SAdicionalDTO dto) {
        ModelMapper m = new ModelMapper();
        ServiciosAdicionales s = m.map(dto, ServiciosAdicionales.class);
        sI.insert(s);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<SAdicionalDTO> list() {
        return sI.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SAdicionalDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void delete(@PathVariable int id) {
        sI.delete(id);
    }

    @GetMapping("/listarId/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public SAdicionalDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        SAdicionalDTO dto = m.map(sI.listarId(id), SAdicionalDTO.class);
        return dto;
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody SAdicionalDTO dto) {
        ModelMapper m = new ModelMapper();
        ServiciosAdicionales s = m.map(dto, ServiciosAdicionales.class);
        sI.modificar(s);
    }
}
