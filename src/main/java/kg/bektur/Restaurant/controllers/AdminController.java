package kg.bektur.Restaurant.controllers;

import kg.bektur.Restaurant.dto.PersonDto;
import kg.bektur.Restaurant.mapper.PersonMapper;
import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        adminService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
