package kg.bektur.Restaurant.mapper;

import kg.bektur.Restaurant.dto.ReservationDto;
import kg.bektur.Restaurant.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper extends AbstractMapper<Reservation, ReservationDto> {
    @Autowired
    ReservationMapper() {
        super(Reservation.class, ReservationDto.class);
    }

}
