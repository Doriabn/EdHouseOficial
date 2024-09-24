package pe.edu.upc.ehousetp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.ehousetp.entities.Habitacion;
import pe.edu.upc.ehousetp.entities.ServiciosAdicionales;
import pe.edu.upc.ehousetp.entities.Usuario;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private int idReserva;
    private int cantidadPersonas;
    private LocalDate fechaReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double precioTotal;
    private String estadoReserva;
    private Usuario usuario;
    private Habitacion habitacion;
    private ServiciosAdicionales serviciosAdicionales;
}
