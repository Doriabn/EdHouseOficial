package pe.edu.upc.ehousetp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ehousetp.dtos.UsuarioDTO;
import pe.edu.upc.ehousetp.entities.Usuario;
import pe.edu.upc.ehousetp.interfaceservice.UsuarioInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioInterface uI;
    @PostMapping("/insert")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public void insert(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uI.insert(u);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<UsuarioDTO> list() {
        return uI.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void delete(@PathVariable int id) {
        uI.delete(id);
    }

    @GetMapping("/listarId/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public UsuarioDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uI.listarId(id), UsuarioDTO.class);
        return dto;
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uI.modificar(u);
    }

}
