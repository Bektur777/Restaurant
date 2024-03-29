package kg.bektur.Restaurant.controllers;

import jakarta.validation.Valid;
import kg.bektur.Restaurant.dto.UserDto;
import kg.bektur.Restaurant.dto.RestaurantDto;
import kg.bektur.Restaurant.dto.SeatReservationDto;
import kg.bektur.Restaurant.mapper.UserMapper;
import kg.bektur.Restaurant.mapper.RestaurantMapper;
import kg.bektur.Restaurant.mapper.SeatReservationMapper;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.models.SeatReservation;
import kg.bektur.Restaurant.services.UserService;
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
    private final UserService userService;
    private final RestaurantService restaurantService;
    private final SeatReservationService seatReservationService;
    private final UserMapper userMapper;
    private final RestaurantMapper restaurantMapper;
    private final SeatReservationMapper seatReservationMapper;

    @Autowired
    public AdminController(UserService userService, RestaurantService restaurantService, SeatReservationService seatReservationService, UserMapper userMapper, RestaurantMapper restaurantMapper, SeatReservationMapper seatReservationMapper) {
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.seatReservationService = seatReservationService;
        this.userMapper = userMapper;
        this.restaurantMapper = restaurantMapper;
        this.seatReservationMapper = seatReservationMapper;
    }

    @GetMapping("/all-users")
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        if (userService.findUserById(id).isPresent())
            return userMapper.toDto(userService.findUserById(id).get());

        throw new ErrorException("User with this id not found");
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        try {
            userService.softDeleteById(id);
        } catch (Exception e) {
            throw new ErrorException("Person with this id not found");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<HttpStatus> updateUserRole(@RequestBody @Valid UserDto personDto,
                                                     @PathVariable("id") Long id) {
        try {
            userService.updateRole(userMapper.toEntity(personDto), id);
        } catch (Exception e) {
            throw new ErrorException("Error in updating");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all-restaurant")
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

    @PostMapping("/restaurant/create")
    public ResponseEntity<HttpStatus> createRestaurant(@RequestBody @Valid RestaurantDto restaurantDto) {
        restaurantService.saveRestaurant(restaurantMapper.toEntity(restaurantDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/restaurant/update/{id}")
    public ResponseEntity<HttpStatus> updateRestaurant(@RequestBody @Valid RestaurantDto restaurantDto,
                                                       @PathVariable("id") Long id) {
        restaurantService.updateRestaurant(restaurantMapper.toEntity(restaurantDto), id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/restaurant/delete/{id}")
    public ResponseEntity<HttpStatus> deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all-seat-reservations")
    public List<SeatReservationDto> getAllSeatReservations() {
        return seatReservationService.findAllSeatReservations().stream().map(seatReservationMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/seat-reservation/{id}")
    public SeatReservationDto getSeatReservationById(@PathVariable("id") Long id) {
        Optional<SeatReservation> seatReservation = seatReservationService.findSeatReservationById(id);
        if (seatReservation.isPresent())
            return seatReservationMapper.toDto(seatReservation.get());

        throw new ErrorException("Seat reservation with this id not found");
    }

    @PostMapping("/seat-reservation/create")
    public ResponseEntity<HttpStatus> createSeatReservation(@RequestBody @Valid SeatReservationDto seatReservationDto) {
        seatReservationService.saveSeatReservation(seatReservationMapper.toEntity(seatReservationDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/seat-reservation/update/{id}")
    public ResponseEntity<HttpStatus> updateSeatReservation(@RequestBody @Valid SeatReservationDto seatReservationDto,
                                                       @PathVariable("id") Long id) {
        seatReservationService.updateSeatReservation(seatReservationMapper.toEntity(seatReservationDto), id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/seat-reservation/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSeatReservation(@PathVariable("id") Long id) {
        seatReservationService.deleteSeatReservation(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(ErrorException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
