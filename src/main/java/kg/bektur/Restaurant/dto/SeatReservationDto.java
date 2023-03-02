package kg.bektur.Restaurant.dto;

import jakarta.validation.constraints.NotEmpty;
import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.models.Restaurant;
import lombok.Data;

import java.util.List;

@Data
public class SeatReservationDto extends AbstractDto {
    @NotEmpty(message = "The seat number shouldn't be empty")
    private int seatNumber;
    @NotEmpty(message = "The capacity shouldn't be empty")
    private int capacity;
    @NotEmpty(message = "The description shouldn't be empty")
    private String description;
    private Restaurant owner;
    private List<Reservation> reservationList;

}
