package kg.bektur.Restaurant.mapper;

import kg.bektur.Restaurant.dto.RegistrationDto;
import kg.bektur.Restaurant.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper extends AbstractMapper<User, RegistrationDto> {
    @Autowired
    RegistrationMapper() {
        super(User.class, RegistrationDto.class);
    }
}
