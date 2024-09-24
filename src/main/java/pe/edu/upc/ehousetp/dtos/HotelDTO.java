package pe.edu.upc.ehousetp.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private int idHotel;
    private String nombreHotel;
    private String direccionHotel;
    private String telefonoHotel;
    private String correoHotel;

}
