package kg.bektur.Restaurant.controllers;

import kg.bektur.Restaurant.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloController {
    @GetMapping("/hello")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl personDetails = (UserDetailsImpl) authentication.getPrincipal();
        return personDetails.getUsername();
    }
}
