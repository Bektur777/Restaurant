package kg.bektur.Restaurant.mapper;

import kg.bektur.Restaurant.dto.SeatReservationDto;
import kg.bektur.Restaurant.models.SeatReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeatReservationMapper extends AbstractMapper<SeatReservation, SeatReservationDto> {
    @Autowired
    SeatReservationMapper() {
        super(SeatReservation.class, SeatReservationDto.class);
    }
}
