package kg.bektur.Restaurant.services;

import jakarta.persistence.EntityManager;
import kg.bektur.Restaurant.models.SeatReservation;
import kg.bektur.Restaurant.repositories.SeatReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatReservationService {
    private final SeatReservationRepository seatReservationRepository;
    private final EntityManager entityManager;

    public SeatReservationService(SeatReservationRepository seatReservationRepository, EntityManager entityManager) {
        this.seatReservationRepository = seatReservationRepository;
        this.entityManager = entityManager;
    }

    public List<SeatReservation> findAllSeatReservations() {
        return seatReservationRepository.findAll();
    }

    public Optional<SeatReservation> findSeatReservationById(Long id) {
        return seatReservationRepository.findById(id);
    }

    public void saveSeatReservation(SeatReservation seatReservation) {
        seatReservationRepository.save(seatReservation);
    }

    public void updateSeatReservation(SeatReservation seatReservation, Long id) {
        seatReservation.setId(id);
        seatReservationRepository.save(seatReservation);
    }

    public void deleteSeatReservation(Long id) {
        entityManager.remove(seatReservationRepository.findById(id));
    }

}
