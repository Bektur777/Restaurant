package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public AdminService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAllUsers() {
        return peopleRepository.findAll();
    }

    public void delete(Person person) {
        peopleRepository.delete(person);
    }

}
