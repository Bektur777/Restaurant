package kg.bektur.Restaurant.dto;

import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.models.SeatReservation;

import java.util.List;

public class RestaurantDto extends AbstractDto {
    private int id;
    private String name;
    private String description;
    private String address;
    private String phone;
    private List<SeatReservation> seatReservationList;
    private List<Reservation> reservationList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<SeatReservation> getSeatReservationList() {
        return seatReservationList;
    }

    public void setSeatReservationList(List<SeatReservation> seatReservationList) {
        this.seatReservationList = seatReservationList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

}
