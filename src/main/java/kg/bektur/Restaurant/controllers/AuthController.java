package kg.bektur.Restaurant.controllers;

import kg.bektur.Restaurant.dto.PersonDto;
import kg.bektur.Restaurant.mapper.PersonMapper;
import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.security.JWTUtil;
import kg.bektur.Restaurant.services.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JWTUtil jwtUtil;
    private final RegistrationService registrationService;
    private final PersonMapper personMapper;

    public AuthController(JWTUtil jwtUtil, RegistrationService registrationService, PersonMapper personMapper) {
        this.jwtUtil = jwtUtil;
        this.registrationService = registrationService;
        this.personMapper = personMapper;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/registration")
    public Map<String, String> registration(@RequestBody PersonDto personDto) {
        Person person = personMapper.toEntity(personDto);

        registrationService.register(person);

        return Map.of("jwt-token", jwtUtil.generationToken(person.getUsername()));
    }

}
