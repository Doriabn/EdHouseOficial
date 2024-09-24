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
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHabitacion;
    @Column(name="tipoHabitacion", nullable = false,length = 100)
    private String tipoHabitacion;
    @Column(name="disponibilidad", nullable = false)
    private String disponibilidad;
    @Column(name="descripcionHabitacion", nullable = false, length = 200)
    private String descripcionHabitacion;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

}
