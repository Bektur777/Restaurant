package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.dto.ReservationDto;
import kg.bektur.Restaurant.mapper.ReservationMapper;
import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.models.SeatReservation;
import kg.bektur.Restaurant.repositories.PeopleRepository;
import kg.bektur.Restaurant.repositories.ReservationRepository;
import kg.bektur.Restaurant.repositories.RestaurantRepository;
import kg.bektur.Restaurant.repositories.SeatReservationRepository;
import kg.bektur.Restaurant.util.ErrorException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RestaurantRepository restaurantRepository;
    private final SeatReservationRepository seatReservationRepository;
    private final PeopleRepository peopleRepository;
    private final PersonDetailsService personDetailsService;
    private final ReservationMapper reservationMapper;
    private final ModelMapper mapper;

    public ReservationService(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository, SeatReservationRepository seatReservationRepository, PeopleRepository peopleRepository, PersonDetailsService personDetailsService, ReservationMapper reservationMapper, ModelMapper mapper) {
        this.reservationRepository = reservationRepository;
        this.restaurantRepository = restaurantRepository;
        this.seatReservationRepository = seatReservationRepository;
        this.peopleRepository = peopleRepository;
        this.personDetailsService = personDetailsService;
        this.reservationMapper = reservationMapper;
        this.mapper = mapper;
    }

    public List<Reservation> findReservationByPersonId(Long person_id) {
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
    public void addReservation(ReservationDto reservationDto) {
        Reservation reservation = reservationMapper.toEntity(reservationDto);

        Person person = personDetailsService.getCurrentUser();
        reservation.setPerson(mapper.map(person, Person.class));

        boolean isAvailable = isAvailable(reservationDto.getStartDate(), reservationDto.getEndDate(),
                reservationRepository.findAllBySeatReservationIdAndRestaurantId(
                        reservationDto.getSeatReservation().getId(),
                        reservationDto.getRestaurant().getId()
                ));

        if (isAvailable) {
            reservationRepository.save(reservation);
        } else {
            throw new ErrorException("This time is taken");
        }
    }

}
