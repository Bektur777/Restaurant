package kg.bektur.Restaurant.repositories;

import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.models.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationByPersonId(Long person_id);
    List<Reservation> findAllBySeatReservationIdAndRestaurantId(Long seatReservation_id, Long restaurant_id);
}
