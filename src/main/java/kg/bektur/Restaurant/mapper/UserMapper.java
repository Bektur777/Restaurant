package kg.bektur.Restaurant.mapper;

import kg.bektur.Restaurant.dto.UserDto;
import kg.bektur.Restaurant.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDto> {
    @Autowired
    UserMapper() {
        super(User.class, UserDto.class);
    }

}
