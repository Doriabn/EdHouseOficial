package pe.edu.upc.ehousetp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.ehousetp.entities.Usuario;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RolDTO {
    private Long id;
    private String nombreRol;
    private Usuario usuario;

}
