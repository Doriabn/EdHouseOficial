package pe.edu.upc.ehousetp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rol")
public class Rol {
    private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "nombreRol", length = 30, nullable = false)
    private String nombreRol;

@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

}
