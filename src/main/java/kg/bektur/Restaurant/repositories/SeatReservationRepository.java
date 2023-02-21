package kg.bektur.Restaurant.repositories;

import kg.bektur.Restaurant.models.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface SeatReservationRepository extends JpaRepository<SeatReservation, Integer> {
}
