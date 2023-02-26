package kg.bektur.Restaurant.dto;

import jakarta.validation.constraints.NotEmpty;
import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.models.SeatReservation;

import java.util.List;

public class RestaurantDto extends AbstractDto {
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
