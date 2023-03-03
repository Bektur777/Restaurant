package kg.bektur.Restaurant.repositories;

import kg.bektur.Restaurant.models.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface SeatReservationRepository extends JpaRepository<SeatReservation, Long> {
    @Modifying
    @Query("UPDATE SeatReservation s SET s.deleted = true WHERE s.id = :id")
    void softDelete(@Param("id") Long id);

}
