package pe.edu.upc.ehousetp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.ehousetp.entities.Hotel;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionDTO {
    private int idHabitacion;
    private String tipoHabitacion;
    private String disponibilidad;
    private String descripcionHabitacion;
    private Hotel hotel;

}
