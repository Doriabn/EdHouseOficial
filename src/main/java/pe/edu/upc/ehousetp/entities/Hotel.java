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
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHotel;
    @Column(name="nombreHotel", nullable = false,length = 100)
    private String nombreHotel;
    @Column(name="direccionHotel", nullable = false,length = 200)
    private String direccionHotel;
    @Column(name="telefonoHotel", nullable = false,length = 9)
    private String telefonoHotel;
    @Column(name="correoHotel", nullable = false,length = 50)
    private String correoHotel;

}
