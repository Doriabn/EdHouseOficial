package pe.edu.upc.ehousetp.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    public int id;
    public String nombre;
    public String apellido;
    public String telefono;
    public LocalDate fechaNacimiento;
    public String email;
    public String username;
    public String password;
    private Boolean enabled;


}
