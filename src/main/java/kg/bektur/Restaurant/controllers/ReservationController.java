package kg.bektur.Restaurant.controllers;

import kg.bektur.Restaurant.dto.ReservationDto;
import kg.bektur.Restaurant.dto.RestaurantDto;
import kg.bektur.Restaurant.dto.SeatReservationDto;
import kg.bektur.Restaurant.mapper.ReservationMapper;
import kg.bektur.Restaurant.mapper.RestaurantMapper;
import kg.bektur.Restaurant.mapper.SeatReservationMapper;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.models.SeatReservation;
import kg.bektur.Restaurant.services.ReservationService;
import kg.bektur.Restaurant.services.RestaurantService;
import kg.bektur.Restaurant.services.SeatReservationService;
import kg.bektur.Restaurant.util.ErrorException;
import kg.bektur.Restaurant.util.ErrorResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;
    private final SeatReservationService seatReservation;
    private final SeatReservationMapper seatReservationMapper;
    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationController(RestaurantService restaurantService, RestaurantMapper restaurantMapper, SeatReservationService seatReservation, SeatReservationMapper seatReservationMapper, ReservationService reservationService, ReservationMapper reservationMapper) {
        this.restaurantService = restaurantService;
        this.restaurantMapper = restaurantMapper;
        this.seatReservation = seatReservation;
        this.seatReservationMapper = seatReservationMapper;
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @GetMapping("/all-restaurants")
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantService.findAllRestaurants().stream().map(restaurantMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/restaurant/{id}")
    public RestaurantDto getRestaurantById(@PathVariable("id") Long id) {
        Optional<Restaurant> restaurant = restaurantService.findRestaurantById(id);
        if (restaurant.isPresent())
            return restaurantMapper.toDto(restaurant.get());

        throw new ErrorException("Restaurant with this id not found");
    }

    @GetMapping("/seat-reservations")
    public List<SeatReservationDto> getSeatReservations() {
        return seatReservation.findAllSeatReservations().stream().map(seatReservationMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/seat-reservation/{id}")
    private SeatReservationDto getSeatReservation(@PathVariable("id") Long id) {
        Optional<SeatReservation> sR = seatReservation.findSeatReservationById(id);
        if (sR.isPresent())
            return seatReservationMapper.toDto(sR.get());

        throw new ErrorException("Seat reservation with this id not found");
    }

    @PostMapping("/add-reservation")
    public ResponseEntity<HttpStatus> addReservation(@RequestBody ReservationDto reservationDto ) {
        reservationService.addReservation(reservationDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/reservation/{id}")
    public List<ReservationDto> getReservations(@PathVariable("id") Long id) {
        return reservationService.findReservationByPersonId(id).stream()
                .map(reservationMapper::toDto)
                .collect(Collectors.toList());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(ErrorException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
