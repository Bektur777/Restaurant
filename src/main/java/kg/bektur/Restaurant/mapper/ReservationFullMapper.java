package kg.bektur.Restaurant.mapper;

import kg.bektur.Restaurant.dto.ReservationFullDto;
import kg.bektur.Restaurant.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationFullMapper extends AbstractMapper<Reservation, ReservationFullDto> {
    @Autowired
    ReservationFullMapper() {
        super(Reservation.class, ReservationFullDto.class);
    }
}
