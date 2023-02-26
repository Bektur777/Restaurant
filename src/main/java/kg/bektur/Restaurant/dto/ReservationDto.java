package kg.bektur.Restaurant.dto;

import jakarta.validation.constraints.NotEmpty;
import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.models.SeatReservation;

import java.time.LocalDateTime;

public class ReservationDto extends AbstractDto {
    private Long id;
    @NotEmpty(message = "The date shouldn't be empty")
    private LocalDateTime startDate;
    @NotEmpty(message = "The date shouldn't be empty")
    private LocalDateTime endDate;
    private SeatReservation seatReservation;
    private Restaurant restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public SeatReservation getSeatReservation() {
        return seatReservation;
    }

    public void setSeatReservation(SeatReservation seatReservation) {
        this.seatReservation = seatReservation;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", seatReservation=" + seatReservation +
                ", restaurant=" + restaurant +
                '}';
    }

}
