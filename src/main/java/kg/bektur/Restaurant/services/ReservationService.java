package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Optional<Reservation> findReservationByPersonId(int person_id) {
        return reservationRepository.findReservationByPersonId(person_id);
    }

}
