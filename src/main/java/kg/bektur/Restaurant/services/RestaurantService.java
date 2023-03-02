package kg.bektur.Restaurant.services;

import jakarta.persistence.EntityManager;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final EntityManager entityManager;

    public RestaurantService(RestaurantRepository restaurantRepository, EntityManager entityManager) {
        this.restaurantRepository = restaurantRepository;
        this.entityManager = entityManager;
    }

    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> findRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(Restaurant restaurant, Long id) {
        restaurant.setId(id);
        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        entityManager.remove(restaurantRepository.findById(id));
    }

}
