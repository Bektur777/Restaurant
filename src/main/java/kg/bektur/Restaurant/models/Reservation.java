package kg.bektur.Restaurant.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Reservation")
public class Reservation extends AbstractEntity {
    @Id
    @Column(name = "id", insertable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
    @JsonBackReference
    private Person person;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
    @JsonBackReference
    private SeatReservation seatReservation;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
    @JsonBackReference
    private Restaurant restaurant;

    public Reservation() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public Reservation(int id, LocalDateTime startDate, LocalDateTime endDate, Person person, SeatReservation seatReservation, Restaurant restaurant) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.person = person;
        this.seatReservation = seatReservation;
        this.restaurant = restaurant;
    }
}
