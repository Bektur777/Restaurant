package kg.bektur.Restaurant.controllers;

import kg.bektur.Restaurant.dto.ReservationDto;
import kg.bektur.Restaurant.dto.ReservationFullDto;
import kg.bektur.Restaurant.mapper.ReservationFullMapper;
import kg.bektur.Restaurant.mapper.ReservationMapper;
import kg.bektur.Restaurant.models.Reservation;
import kg.bektur.Restaurant.services.ReservationService;
import kg.bektur.Restaurant.util.ErrorException;
import kg.bektur.Restaurant.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;
    public CustomerController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @GetMapping("/{id}/reservation")
    public ReservationDto getReservationInfo(@PathVariable("id") int id) {
        Optional<Reservation> reservation = reservationService.findReservationByPersonId(id);
        if (reservation.isPresent())
            return reservationMapper.toDto(reservation.get());
        else
            throw new ErrorException("You do not have the reservation");
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(ErrorException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
