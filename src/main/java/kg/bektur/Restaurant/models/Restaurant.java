package kg.bektur.Restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@Entity
@Table(name = "Restaurant")
@Where(clause = "deleted = false")
public class Restaurant extends AbstractEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SeatReservation> seatReservationList;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Reservation> reservationList;

}
