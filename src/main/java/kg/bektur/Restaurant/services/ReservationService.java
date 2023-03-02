package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.dto.ReservationDto;
import kg.bektur.Restaurant.mapper.ReservationMapper;
import kg.bektur.Restaurant.models.User;
import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.repositories.ReservationRepository;
import kg.bektur.Restaurant.util.ErrorException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserDetailsService userDetailsService;
    private final ReservationMapper reservationMapper;
    private final ModelMapper mapper;

    public ReservationService(ReservationRepository reservationRepository, UserDetailsService userDetailsService, ReservationMapper reservationMapper, ModelMapper mapper) {
        this.reservationRepository = reservationRepository;
        this.userDetailsService = userDetailsService;
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

        User person = userDetailsService.getCurrentUser();
        reservation.setPerson(mapper.map(person, User.class));

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
