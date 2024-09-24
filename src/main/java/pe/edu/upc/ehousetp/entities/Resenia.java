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
@Table(name = "resenia")
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResenia;
    @Column(name="puntuacion", nullable = false)
    private int puntuacion;
    @Column(name="fechaResenia", nullable = false)
    private LocalDate fechaResenia;
    @Column(name="descripcionResenia",length = 200, nullable = false)
    private String descripcionResenia;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "habitacion_id", nullable = false)
    private Habitacion habitacion;
}
