package kg.bektur.Restaurant.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;

@Entity
@Table(name = "Reservation")
public class Reservation extends AbstractEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @ManyToOne
    @JsonIgnore
    private Person person;
    @ManyToOne
    @JsonIgnore
    private SeatReservation seatReservation;
    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

    public Reservation() {}

    public Reservation(LocalDateTime startDate, LocalDateTime endDate, Person person, SeatReservation seatReservation, Restaurant restaurant) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.person = person;
        this.seatReservation = seatReservation;
        this.restaurant = restaurant;
    }

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

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", person=" + person +
                ", seatReservation=" + seatReservation +
                ", restaurant=" + restaurant +
                '}';
    }
}
