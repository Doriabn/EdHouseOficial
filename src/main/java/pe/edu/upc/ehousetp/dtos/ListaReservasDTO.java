package pe.edu.upc.ehousetp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaReservasDTO {
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private int idReserva;
    private LocalDate fechaReserva;
    private String nombreHotel;
}
