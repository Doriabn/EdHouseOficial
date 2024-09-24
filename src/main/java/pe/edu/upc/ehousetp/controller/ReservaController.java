package pe.edu.upc.ehousetp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ehousetp.dtos.*;
import pe.edu.upc.ehousetp.entities.Reserva;
import pe.edu.upc.ehousetp.interfaceservice.ReservaInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")

public class ReservaController {
    @Autowired
    private ReservaInterface rI;

    @PostMapping("/insert")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public void insert(@RequestBody ReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reserva r = m.map(dto, Reserva.class);
        rI.insert(r);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<ReservaDTO> list() {
        return rI.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ReservaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public void delete(@PathVariable int id) {
        rI.delete(id);
    }

    @GetMapping("/listarId/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public ReservaDTO listarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        ReservaDTO dto = m.map(rI.listarId(id), ReservaDTO.class);
        return dto;
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public void modificar(@RequestBody ReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reserva r = m.map(dto, Reserva.class);
        rI.modificar(r);
    }

    @GetMapping("/listarReservas")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<ListaReservasDTO> listaReservas() {
        List<String[]> lista = rI.listaReservas();
        List<ListaReservasDTO> listaDTO = new java.util.ArrayList<>();
        for (String[] columna : lista) {
            ListaReservasDTO dto = new ListaReservasDTO();
            dto.setIdUsuario(Integer.parseInt(columna[0]));
            dto.setNombreUsuario(columna[1]);
            dto.setApellidoUsuario(columna[2]);
            dto.setIdReserva(Integer.parseInt(columna[3]));
            dto.setFechaReserva(LocalDate.parse(columna[4]));
            dto.setNombreHotel(columna[5]);

            listaDTO.add(dto);

        }
        return listaDTO;
    }


    @GetMapping("/totalRecaudado")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<TotalRecaudadoDTO> totalRecaudado() {
        List<String[]> lista = rI.totalRecaudado();
        List<TotalRecaudadoDTO> listaDTO = new java.util.ArrayList<>();
        for (String[] columna : lista) {
            TotalRecaudadoDTO dto = new TotalRecaudadoDTO();
            dto.setTotalRecaudado(Double.parseDouble(columna[0]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/reservasHoy")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public Long countReservasByFechaReserva() {
        return rI.countReservasByFechaReserva();
    }
}
