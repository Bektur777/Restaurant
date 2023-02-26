package kg.bektur.Restaurant.controllers;

import jakarta.validation.Valid;
import kg.bektur.Restaurant.dto.AuthenticationDto;
import kg.bektur.Restaurant.dto.PersonDto;
import kg.bektur.Restaurant.mapper.PersonMapper;
import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.security.JWTUtil;
import kg.bektur.Restaurant.services.RegistrationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JWTUtil jwtUtil;
    private final RegistrationService registrationService;
    private final PersonMapper personMapper;
    private final AuthenticationManager authenticationManager;

    public AuthController(JWTUtil jwtUtil, RegistrationService registrationService, PersonMapper personMapper, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.registrationService = registrationService;
        this.personMapper = personMapper;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/registration")
    public Map<String, String> registration(@RequestBody @Valid PersonDto personDto) {
        Person person = personMapper.toEntity(personDto);

        registrationService.register(person);

        return Map.of("jwt-token", jwtUtil.generationToken(person.getUsername()));
    }

    @PostMapping("/login")
    public Map<String, String> performLogin(@RequestBody @Valid AuthenticationDto authenticationDto) {
        UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
                authenticationDto.getUsername(),
                authenticationDto.getPassword()
        );

        try {
            authenticationManager.authenticate(authInputToken);
        } catch (BadCredentialsException exception) {
            return Map.of("message", "Incorrect credentials!");
        }

        String token = jwtUtil.generationToken(authenticationDto.getUsername());

        return Map.of("jwt-token", token);
    }

}
