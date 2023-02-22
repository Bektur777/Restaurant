package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.models.Restaurant;
import kg.bektur.Restaurant.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final PeopleRepository peopleRepository;
    private final Restaurant restaurant;

    @Autowired
    public AdminService(PeopleRepository peopleRepository, Restaurant restaurant) {
        this.peopleRepository = peopleRepository;
        this.restaurant = restaurant;
    }

    public List<Person> findAllUsers() {
        return peopleRepository.findAll();
    }

    public void delete(Person person) {
        peopleRepository.delete(person);
    }

    public void updateRole(Person person, String role) {
        person.setRole(role);
        peopleRepository.save(person);
    }

}
