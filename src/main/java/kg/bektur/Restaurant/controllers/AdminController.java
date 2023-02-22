package kg.bektur.Restaurant.controllers;

import kg.bektur.Restaurant.models.Person;
import kg.bektur.Restaurant.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/all_users")
    public List<Person> getAllUsers() {
        return adminService.findAllUsers();
    }

}
