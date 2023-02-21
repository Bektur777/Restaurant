package kg.bektur.Restaurant.mapper;

import kg.bektur.Restaurant.dto.RestaurantDto;
import kg.bektur.Restaurant.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper extends AbstractMapper<Restaurant, RestaurantDto> {
    @Autowired
    RestaurantMapper() {
        super(Restaurant.class, RestaurantDto.class);
    }
}
