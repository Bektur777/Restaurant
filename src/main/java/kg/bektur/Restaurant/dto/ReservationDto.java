package kg.bektur.Restaurant.dto;

import jakarta.validation.constraints.NotEmpty;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.models.SeatReservation;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDto extends AbstractDto {
    @NotEmpty(message = "The date shouldn't be empty")
    private LocalDateTime startDate;
    @NotEmpty(message = "The date shouldn't be empty")
    private LocalDateTime endDate;
    private SeatReservation seatReservation;
    private Restaurant restaurant;

}
