package kg.bektur.Restaurant.services;

import jakarta.persistence.EntityManager;
import kg.bektur.Restaurant.models.User;
import kg.bektur.Restaurant.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Autowired
    public UserService(UserRepository peopleRepository, EntityManager entityManager) {
        this.userRepository = peopleRepository;
        this.entityManager = entityManager;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void softDeleteById(Long id) {
        userRepository.softDelete(id);
    }

    public void updateRole(User user, Long id) {
        user.setId(id);
        userRepository.save(user);
    }

}
