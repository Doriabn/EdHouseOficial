package pe.edu.upc.ehousetp.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SAdicionalDTO {
    private int idServiciosAdicionales;
    private String nombreServicio;
    private double precioServicio;
}
