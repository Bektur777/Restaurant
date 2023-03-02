package kg.bektur.Restaurant.mapper;

import kg.bektur.Restaurant.dto.PersonDto;
import kg.bektur.Restaurant.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper extends AbstractMapper<User, PersonDto> {
    @Autowired
    PersonMapper() {
        super(User.class, PersonDto.class);
    }

}
