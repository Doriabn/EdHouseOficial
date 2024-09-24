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
@Table(name = "servicios_adicionales")
public class ServiciosAdicionales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServiciosAdicionales;
    @Column(name = "nombreServicio", nullable = false,length = 100)
    private String nombreServicio;
    @Column(name = "precioServicio", nullable = false)
    private double precioServicio;


}
