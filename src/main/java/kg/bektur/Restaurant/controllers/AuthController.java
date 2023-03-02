package kg.bektur.Restaurant.controllers;

import jakarta.validation.Valid;
import kg.bektur.Restaurant.dto.AuthenticationDto;
import kg.bektur.Restaurant.dto.RegistrationDto;
import kg.bektur.Restaurant.mapper.RegistrationMapper;
import kg.bektur.Restaurant.models.User;
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
    private final RegistrationMapper registrationMapper;
    private final AuthenticationManager authenticationManager;

    public AuthController(JWTUtil jwtUtil, RegistrationService registrationService, RegistrationMapper registrationMapper, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.registrationService = registrationService;
        this.registrationMapper = registrationMapper;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/registration")
    public Map<String, String> registration(@RequestBody @Valid RegistrationDto registrationDto) {
        User person = registrationMapper.toEntity(registrationDto);

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
