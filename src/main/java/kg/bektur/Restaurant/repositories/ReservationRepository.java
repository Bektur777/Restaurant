package kg.bektur.Restaurant.repositories;

import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.models.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Optional<Reservation> findReservationByPersonId(int person_id);
}
