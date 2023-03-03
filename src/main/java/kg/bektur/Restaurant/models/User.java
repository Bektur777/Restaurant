package kg.bektur.Restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@Entity
@Table(name = "Person")
@Where(clause = "deleted = false")
public class User extends AbstractEntity {
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "number")
    private String number;
    @Column(name = "role")
    private String role;
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Reservation> reservations;

}
