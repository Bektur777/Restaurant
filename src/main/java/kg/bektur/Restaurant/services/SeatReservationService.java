package kg.bektur.Restaurant.services;

import jakarta.persistence.EntityManager;
import kg.bektur.Restaurant.models.SeatReservation;
import kg.bektur.Restaurant.repositories.SeatReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SeatReservationService {
    private final SeatReservationRepository seatReservationRepository;

    public SeatReservationService(SeatReservationRepository seatReservationRepository) {
        this.seatReservationRepository = seatReservationRepository;
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

    @Transactional
    public void updateSeatReservation(SeatReservation seatReservation, Long id) {
        seatReservation.setId(id);
        seatReservationRepository.save(seatReservation);
    }

    @Transactional
    public void deleteSeatReservation(Long id) {
        seatReservationRepository.softDelete(id);
    }

}
