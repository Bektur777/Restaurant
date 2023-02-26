package kg.bektur.Restaurant.mapper;

import jakarta.annotation.PostConstruct;
import kg.bektur.Restaurant.dto.ReservationDto;
import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.models.SeatReservation;
import kg.bektur.Restaurant.repositories.SeatReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ReservationMapper extends AbstractMapper<Reservation, ReservationDto> {
    @Autowired
    public ReservationMapper() {
        super(Reservation.class, ReservationDto.class);
    }

//    @PostConstruct
//    public void setupMapper() {
//        mapper.createTypeMap(Reservation.class, ReservationDto.class)
//                .addMappings(m -> m.skip(ReservationDto::setSeatReservation)).setPostConverter(toDtoConverter());
//        mapper.createTypeMap(ReservationDto.class, Reservation.class)
//                .addMappings(m -> m.skip(Reservation::setSeatReservation)).setPostConverter(toEntityConverter());
//        mapper.createTypeMap(ReservationDto.class, Reservation.class)
//                .addMappings(mapper -> mapper.skip(Reservation::setId))
//                .addMappings(mapper -> mapper.using(context -> {
//                    Long id = (Long) context.getSource();
//                    return id == null ? null : new SeatReservation().getId().;
//                }).map(ReservationDto::getSeatReservation, Reservation::setSeatReservation));
//    }

}
