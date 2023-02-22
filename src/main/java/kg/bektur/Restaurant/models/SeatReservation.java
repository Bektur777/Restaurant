package kg.bektur.Restaurant.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Seat_Reservation")
public class SeatReservation extends AbstractEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "seat_number")
    private int seatNumber;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
    private Restaurant owner;
    @OneToMany(mappedBy = "seatReservation", cascade = CascadeType.PERSIST)
    private List<Reservation> reservationList;
    public SeatReservation() {}

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

    @Override
    public String toString() {
        return "SeatReservation{" +
                "id=" + id +
                ", seatNumber=" + seatNumber +
                ", capacity=" + capacity +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                '}';
    }

}
