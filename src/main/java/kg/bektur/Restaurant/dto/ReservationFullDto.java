package kg.bektur.Restaurant.dto;

import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.models.SeatReservation;

import java.time.LocalDateTime;

public class ReservationFullDto extends AbstractDto {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int person;
    private int seatReservation;
    private int restaurant;

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

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public int getSeatReservation() {
        return seatReservation;
    }

    public void setSeatReservation(int seatReservation) {
        this.seatReservation = seatReservation;
    }

    public int getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(int restaurant) {
        this.restaurant = restaurant;
    }

}
