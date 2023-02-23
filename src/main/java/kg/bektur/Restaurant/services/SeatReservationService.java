package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.models.SeatReservation;
import kg.bektur.Restaurant.repositories.SeatReservationRepository;
import org.springframework.stereotype.Service;

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

    public Optional<SeatReservation> findSeatReservationById(int id) {
        return seatReservationRepository.findById(id);
    }

    public void saveSeatReservation(SeatReservation seatReservation) {
        seatReservationRepository.save(seatReservation);
    }

    public void updateSeatReservation(SeatReservation seatReservation, int id) {
        seatReservation.setId(id);
        seatReservationRepository.save(seatReservation);
    }

    public void deleteSeatReservation(int id) {
        seatReservationRepository.deleteById(id);
    }

}
