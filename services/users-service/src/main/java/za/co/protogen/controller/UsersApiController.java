/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.controller;

/**
 *
 * @author Dell
 */
import org.springframework.web.bind.annotation.*;
import za.co.protogen.domain.User;

import java.util.List;
import za.co.protogen.utility.Constants;

@RestController
@RequestMapping("/users")
public class UsersApiController {
    private List<User> users = Constants.USERS; // Assume you have a Constants class with a USERS collection

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    // Implement other CRUD operations similarly...
}