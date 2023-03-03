package kg.bektur.Restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Reservation")
@Where(clause = "deleted = false")
public class Reservation extends AbstractEntity {
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @ManyToOne
    @JsonIgnore
    private User person;
    @ManyToOne
    @JsonIgnore
    private SeatReservation seatReservation;
    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

}
