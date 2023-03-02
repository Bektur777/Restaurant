package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.enums.Role;
import kg.bektur.Restaurant.models.User;
import kg.bektur.Restaurant.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(User person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(String.valueOf(Role.ROLE_USER));
        userRepository.save(person);
    }

}
