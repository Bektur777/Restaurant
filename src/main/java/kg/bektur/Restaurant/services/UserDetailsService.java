package kg.bektur.Restaurant.services;

import kg.bektur.Restaurant.models.User;
import kg.bektur.Restaurant.repositories.UserRepository;
import kg.bektur.Restaurant.security.UserDetailsImpl;
import kg.bektur.Restaurant.util.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepository userRepository;
    private Optional<User> user;

    @Autowired
    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user = userRepository.findByUsername(username);
        if (user.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new UserDetailsImpl(user.get());
    }

    public User getCurrentUser() {
        if (user.isPresent())
            return user.get();

        throw new ErrorException("The user is empty");
    }

}
