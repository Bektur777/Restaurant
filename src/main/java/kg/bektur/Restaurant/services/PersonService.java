package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.repositories.PeopleRepository;
import kg.bektur.Restaurant.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAllUsers() {
        return peopleRepository.findAll();
    }

    public Optional<Person> findUserById(Long id) {
        return peopleRepository.findById(id);
    }

    public void delete(Long id) {
        peopleRepository.deleteById(id);
    }

    public void updateRole(Person person, Long id) {
        person.setId(id);
        peopleRepository.save(person);
    }

}
