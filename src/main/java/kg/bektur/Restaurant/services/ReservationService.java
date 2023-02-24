package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.dto.ReservationFullDto;
import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.models.SeatReservation;
import kg.bektur.Restaurant.repositories.PeopleRepository;
import kg.bektur.Restaurant.repositories.ReservationRepository;
import kg.bektur.Restaurant.repositories.RestaurantRepository;
import kg.bektur.Restaurant.repositories.SeatReservationRepository;
import kg.bektur.Restaurant.util.ErrorException;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RestaurantRepository restaurantRepository;
    private final SeatReservationRepository seatReservationRepository;
    private final PeopleRepository peopleRepository;

    public ReservationService(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository, SeatReservationRepository seatReservationRepository, PeopleRepository peopleRepository) {
        this.reservationRepository = reservationRepository;
        this.restaurantRepository = restaurantRepository;
        this.seatReservationRepository = seatReservationRepository;
        this.peopleRepository = peopleRepository;
    }

    public Optional<Reservation> findReservationByPersonId(int person_id) {
        return reservationRepository.findReservationByPersonId(person_id);
    }

    public boolean isAvailable(LocalDateTime startDate, LocalDateTime endDate, List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            if (reservation.getStartDate().isBefore(endDate) && startDate.isBefore(reservation.getEndDate()))
                return false;
        }
        return true;
    }

    @Transactional
    public void addReservation(Reservation reservation) {
        boolean isAvailable = isAvailable(reservation.getStartDate(), reservation.getEndDate(),
                reservationRepository.findAllBySeatReservationIdAndRestaurantId(
                        reservation.getSeatReservation().getId(),
                        reservation.getRestaurant().getId()));
        Person person = peopleRepository.findById(reservation.getPerson().getId()).get();
        Restaurant restaurant = restaurantRepository.findById(reservation.getRestaurant().getId()).get();
        SeatReservation seatReservation = seatReservationRepository.findById(reservation.getSeatReservation().getId()).get();
        reservation.setPerson(person);
        reservation.setRestaurant(restaurant);
        reservation.setSeatReservation(seatReservation);
        if (isAvailable) {
            reservationRepository.save(reservation);
        } else {
            throw new ErrorException("This time is taken");
        }
    }

}
