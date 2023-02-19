package kg.bektur.Restaurant.mapper;

import kg.bektur.Restaurant.dto.PersonDto;
import kg.bektur.Restaurant.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper extends AbstractMapper<Person, PersonDto> {
    @Autowired
    PersonMapper() {
        super(Person.class, PersonDto.class);
    }

}
