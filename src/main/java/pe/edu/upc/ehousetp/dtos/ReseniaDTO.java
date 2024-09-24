package pe.edu.upc.ehousetp.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.ehousetp.entities.Habitacion;
import pe.edu.upc.ehousetp.entities.Usuario;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReseniaDTO {
    private int idResenia;
    private int puntuacion;
    private LocalDate fechaResenia;
    private String descripcionResenia;
    private Usuario usuario;
    private Habitacion habitacion;

}
