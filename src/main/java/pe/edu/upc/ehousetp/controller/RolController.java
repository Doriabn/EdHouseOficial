package pe.edu.upc.ehousetp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ehousetp.dtos.RolDTO;
import pe.edu.upc.ehousetp.entities.Rol;
import pe.edu.upc.ehousetp.interfaceservice.RolInterfaces;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolInterfaces rI;

    @PostMapping("/insert")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void insert(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rI.insert(r);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<RolDTO> list() {
        return rI.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void delete(@PathVariable Long id) {
        rI.delete(id);
    }

    @GetMapping("/listarId/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public RolDTO listarId(@PathVariable Long id) {
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rI.listarId(id), RolDTO.class);
        return dto;
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rI.modificar(r);

    }

}
