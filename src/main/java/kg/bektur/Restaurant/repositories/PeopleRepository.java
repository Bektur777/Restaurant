package kg.bektur.Restaurant.repositories;

import kg.bektur.Restaurant.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface PeopleRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByUsername(String username);
}
