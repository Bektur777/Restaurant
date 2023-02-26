package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.repositories.PeopleRepository;
import kg.bektur.Restaurant.security.PersonDetails;
import kg.bektur.Restaurant.util.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;
    private Optional<Person> person;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        person = peopleRepository.findByUsername(username);
        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new PersonDetails(person.get());
    }

    public Person getCurrentUser() {
        if (person.isPresent())
            return person.get();

        throw new ErrorException("The user is empty");
    }

}
