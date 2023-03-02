package kg.bektur.Restaurant.dto;

import jakarta.validation.constraints.NotEmpty;
import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.models.SeatReservation;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantDto extends AbstractDto {
    @NotEmpty(message = "The name shouldn't be empty")
    private String name;
    @NotEmpty(message = "The description shouldn't be empty")
    private String description;
    @NotEmpty(message = "The address shouldn't be empty")
    private String address;
    @NotEmpty(message = "The phone shouldn't be empty")
    private String phone;
    private List<SeatReservation> seatReservationList;
    private List<Reservation> reservationList;

}
