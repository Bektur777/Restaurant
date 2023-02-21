package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.repositories.SeatReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatReservationService {
    private final SeatReservationRepository seatReservationRepository;

    public SeatReservationService(SeatReservationRepository seatReservationRepository) {
        this.seatReservationRepository = seatReservationRepository;
    }

}
