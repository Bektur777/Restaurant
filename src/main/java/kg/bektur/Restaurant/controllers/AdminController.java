package kg.bektur.Restaurant.controllers;

import kg.bektur.Restaurant.dto.PersonDto;
import kg.bektur.Restaurant.dto.RestaurantDto;
import kg.bektur.Restaurant.dto.SeatReservationDto;
import kg.bektur.Restaurant.mapper.PersonMapper;
import kg.bektur.Restaurant.mapper.RestaurantMapper;
import kg.bektur.Restaurant.mapper.SeatReservationMapper;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.models.SeatReservation;
import kg.bektur.Restaurant.services.PersonService;
import kg.bektur.Restaurant.services.RestaurantService;
import kg.bektur.Restaurant.services.SeatReservationService;
import kg.bektur.Restaurant.util.ErrorException;
import kg.bektur.Restaurant.util.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final PersonService personService;
    private final RestaurantService restaurantService;
    private final SeatReservationService seatReservationService;
    private final PersonMapper personMapper;
    private final RestaurantMapper restaurantMapper;
    private final SeatReservationMapper seatReservationMapper;

    @Autowired
    public AdminController(PersonService personService, RestaurantService restaurantService, SeatReservationService seatReservationService, PersonMapper personMapper, RestaurantMapper restaurantMapper, SeatReservationMapper seatReservationMapper) {
        this.personService = personService;
        this.restaurantService = restaurantService;
        this.seatReservationService = seatReservationService;
        this.personMapper = personMapper;
        this.restaurantMapper = restaurantMapper;
        this.seatReservationMapper = seatReservationMapper;
    }

    @GetMapping("/all_users")
    public List<PersonDto> getAllUsers() {
        return personService.findAllUsers().stream().map(personMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public PersonDto getUserById(@PathVariable("id") int id) {
        if (personService.findUserById(id).isPresent())
            return personMapper.toDto(personService.findUserById(id).get());

        throw new ErrorException("User with this id not found");
    }

    @PostMapping("/user/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        try {
            personService.delete(id);
        } catch (Exception e) {
            throw new ErrorException("Person with this id not found");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/user/update/{id}")
    public ResponseEntity<HttpStatus> updateUserRole(@RequestBody PersonDto personDto,
                                                     @PathVariable("id") int id) {
        try {
            personService.updateRole(personMapper.toEntity(personDto), id);
        } catch (Exception e) {
            throw new ErrorException("Error in updating");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all_restaurant")
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantService.findAllRestaurants().stream().map(restaurantMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/restaurant/{id}")
    public RestaurantDto getRestaurantById(@PathVariable("id") int id) {
        Optional<Restaurant> restaurant = restaurantService.findRestaurantById(id);
        if (restaurant.isPresent())
            return restaurantMapper.toDto(restaurant.get());

        throw new ErrorException("Restaurant with this id not found");
    }

    @PostMapping("/restaurant/create")
    public ResponseEntity<HttpStatus> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.saveRestaurant(restaurantMapper.toEntity(restaurantDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/restaurant/update/{id}")
    public ResponseEntity<HttpStatus> updateRestaurant(@RequestBody RestaurantDto restaurantDto,
                                                       @PathVariable("id") int id) {
        restaurantService.updateRestaurant(restaurantMapper.toEntity(restaurantDto), id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/restaurant/delete/{id}")
    public ResponseEntity<HttpStatus> deleteRestaurant(@PathVariable("id") int id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all_seat_reservations")
    public List<SeatReservationDto> getAllSeatReservations() {
        return seatReservationService.findAllSeatReservations().stream().map(seatReservationMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/seat_reservation/{id}")
    public SeatReservationDto getSeatReservationById(@PathVariable("id") int id) {
        Optional<SeatReservation> seatReservation = seatReservationService.findSeatReservationById(id);
        if (seatReservation.isPresent())
            return seatReservationMapper.toDto(seatReservation.get());

        throw new ErrorException("Seat reservation with this id not found");
    }

    @PostMapping("/seat_reservation/create")
    public ResponseEntity<HttpStatus> createSeatReservation(@RequestBody SeatReservationDto seatReservationDto) {
        seatReservationService.saveSeatReservation(seatReservationMapper.toEntity(seatReservationDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/seat_reservation/update/{id}")
    public ResponseEntity<HttpStatus> updateSeatReservation(@RequestBody SeatReservationDto seatReservationDto,
                                                       @PathVariable("id") int id) {
        seatReservationService.updateSeatReservation(seatReservationMapper.toEntity(seatReservationDto), id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/seat_reservation/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSeatReservation(@PathVariable("id") int id) {
        seatReservationService.deleteSeatReservation(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(ErrorException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
