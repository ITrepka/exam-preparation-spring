package com.example.pretkej.springpreparation.point9.controller;

import com.example.pretkej.springpreparation.point9.exception.NotFound;
import com.example.pretkej.springpreparation.point9.model.User;
import com.example.pretkej.springpreparation.point9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) Integer birthYear) {
        List<User> allUsers = userService.getAllUsers();

        return birthYear == null ? allUsers : userService.filterByBirthYear(allUsers, birthYear);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) throws NotFound {
        return userService.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Integer id) throws NotFound {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable Integer id) throws NotFound {
        return userService.deleteUser(id);
    }
}
