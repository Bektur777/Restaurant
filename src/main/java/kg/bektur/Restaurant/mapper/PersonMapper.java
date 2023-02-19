package kg.bektur.Restaurant.mapper;

import kg.bektur.Restaurant.dto.PersonDto;
import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.repositories.PeopleRepository;
import org.modelmapper.ModelMapper;

public class PersonMapper extends AbstractMapper<Person, PersonDto> {
    public PersonMapper(ModelMapper mapper, Class<Person> entityClass, Class<PersonDto> dtoClass) {
        super(mapper, entityClass, dtoClass);
    }

    @Override
    public Person toEntity(PersonDto dto) {
        return super.toEntity(dto);
    }

    @Override
    public PersonDto toDto(Person entity) {
        return super.toDto(entity);
    }

}
