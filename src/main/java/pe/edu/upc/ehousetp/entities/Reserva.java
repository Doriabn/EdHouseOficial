package pe.edu.upc.ehousetp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reserva")
    private int idReserva;
    @Column(name="cantidadPersonas", nullable = false)
    private int cantidadPersonas;
    @Column(name="fecha_reserva", nullable = false)
    private LocalDate fechaReserva;
    @Column(name="fechaInicio", nullable = false)
    private LocalDate fechaInicio;
    @Column(name="fechaFin", nullable = false)
    private LocalDate fechaFin;
    @Column(name="precioTotal", nullable = false)
    private double precioTotal;
    @Column(name="estadoReserva",length = 30, nullable = false)
    private String estadoReserva;


    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "habitacion_id", nullable = false)
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "sadcionales_id", nullable = true)
    private ServiciosAdicionales serviciosAdicionales;

}
