package pe.edu.upc.ehousetp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListaReseniasDTO {
    private int idUsario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String descripcionResenia;
    private LocalDate fechaResenia;
    private int puntuacion;

}
