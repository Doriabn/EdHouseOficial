package pe.edu.upc.ehousetp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     public int id;
    @Column(name="nombre",length = 30, nullable = false)
    public String nombre;
    @Column(name="apellido",length = 30, nullable = false)
    public String apellido;
    @Column(name="telefono",length = 9, nullable = false)
    public String telefono;
    @Column(name="fechaNacimiento", nullable = false)
    public LocalDate fechaNacimiento;
    @Column(name="email",length = 50, nullable = false)
    public String email;
    @Column(length = 30, unique = true)
    public String username;
    @Column(length = 200)
    public String password;
    private Boolean enabled;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Rol> roles;


}
