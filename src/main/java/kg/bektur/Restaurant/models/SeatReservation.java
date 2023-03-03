package kg.bektur.Restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@Entity
@Table(name = "Seat_Reservation")
@Where(clause = "deleted = false")
public class SeatReservation extends AbstractEntity {
    @Column(name = "seat_number")
    private int seatNumber;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
    @JsonIgnore
    private Restaurant owner;
    @OneToMany(mappedBy = "seatReservation", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Reservation> reservationList;

}
