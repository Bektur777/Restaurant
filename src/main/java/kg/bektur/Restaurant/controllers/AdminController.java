package kg.bektur.Restaurant.controllers;

import kg.bektur.Restaurant.dto.PersonDto;
import kg.bektur.Restaurant.mapper.PersonMapper;
import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final PersonMapper personMapper;

    @Autowired
    public AdminController(AdminService adminService, PersonMapper personMapper) {
        this.adminService = adminService;
        this.personMapper = personMapper;
    }

    @GetMapping("/all_users")
    public List<PersonDto> getAllUsers() {
        return adminService.findAllUsers().stream().map(personMapper::toDto).collect(Collectors.toList());
    }

}
