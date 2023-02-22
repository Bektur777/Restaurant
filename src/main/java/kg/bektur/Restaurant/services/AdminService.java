package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.repositories.PeopleRepository;
import kg.bektur.Restaurant.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final PeopleRepository peopleRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public AdminService(PeopleRepository peopleRepository, RestaurantRepository restaurantRepository) {
        this.peopleRepository = peopleRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Person> findAllUsers() {
        return peopleRepository.findAll();
    }

    public Optional<Person> findUserById(int id) {
        return peopleRepository.findById(id);
    }

    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    public void updateRole(Person person, String role) {
        person.setRole(role);
        peopleRepository.save(person);
    }

    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> findRestaurantById(int id) {
        return restaurantRepository.findById(id);
    }

    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Restaurant restaurant) {
        restaurantRepository.delete(restaurant);
    }

}
