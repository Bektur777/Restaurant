package kg.bektur.Restaurant.dto;

import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.models.Restaurant;

import java.util.List;

public class SeatReservationDto extends AbstractDto {
    private int id;
    private int seatNumber;
    private int capacity;
    private String description;
    private Restaurant owner;
    private List<Reservation> reservationList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Restaurant getOwner() {
        return owner;
    }

    public void setOwner(Restaurant owner) {
        this.owner = owner;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

}