package kg.bektur.Restaurant.controllers;

import kg.bektur.Restaurant.dto.PersonDto;
import kg.bektur.Restaurant.dto.RestaurantDto;
import kg.bektur.Restaurant.mapper.PersonMapper;
import kg.bektur.Restaurant.mapper.RestaurantMapper;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.services.AdminService;
import kg.bektur.Restaurant.util.ErrorException;
import kg.bektur.Restaurant.util.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final PersonMapper personMapper;
    private final RestaurantMapper restaurantMapper;

    @Autowired
    public AdminController(AdminService adminService, PersonMapper personMapper, RestaurantMapper restaurantMapper) {
        this.adminService = adminService;
        this.personMapper = personMapper;
        this.restaurantMapper = restaurantMapper;
    }

    @GetMapping("/all_users")
    public List<PersonDto> getAllUsers() {
        return adminService.findAllUsers().stream().map(personMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public PersonDto getUserById(@PathVariable("id") int id) {
        if (adminService.findUserById(id).isPresent())
            return personMapper.toDto(adminService.findUserById(id).get());

        throw new ErrorException("User with this id not found");
    }

    @PostMapping("/user/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        try {
            adminService.delete(id);
        } catch (Exception e) {
            throw new ErrorException("Person with this id not found");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/user/update/{id}")
    public ResponseEntity<HttpStatus> updateUserRole(@RequestBody PersonDto personDto,
                                                     @PathVariable("id") int id) {
        try {
            adminService.updateRole(personMapper.toEntity(personDto), id);
        } catch (Exception e) {
            throw new ErrorException("Error in updating");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all_restaurant")
    public List<RestaurantDto> getAllRestaurants() {
        return adminService.findAllRestaurants().stream().map(restaurantMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/restaurant/{id}")
    public RestaurantDto getRestaurantById(@PathVariable("id") int id) {
        Optional<Restaurant> restaurant = adminService.findRestaurantById(id);
        if (restaurant.isPresent())
            return restaurantMapper.toDto(restaurant.get());

        throw new ErrorException("Restaurant with this id not found");
    }

    @PostMapping("/restaurant/create")
    public ResponseEntity<HttpStatus> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        adminService.saveRestaurant(restaurantMapper.toEntity(restaurantDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/restaurant/update/{id}")
    public ResponseEntity<HttpStatus> updateRestaurant(@RequestBody RestaurantDto restaurantDto,
                                                       @PathVariable("id") int id) {
        adminService.updateRestaurant(restaurantMapper.toEntity(restaurantDto), id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/restaurant/delete/{id}")
    public ResponseEntity<HttpStatus> deleteRestaurant(@PathVariable("id") int id) {
        adminService.deleteRestaurant(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(ErrorException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
