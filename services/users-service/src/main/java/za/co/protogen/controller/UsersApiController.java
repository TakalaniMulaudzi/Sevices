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


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import za.co.protogen.adapter.UserMapper;
import za.co.protogen.core.impl.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.persistence.models.UserDTO;
import za.co.protogen.persistence.models.UserDomain;
import za.co.protogen.utility.Constant;


@RestController
@RequestMapping("/users")
public class UsersApiController {
    private final List<User> users = Constant.users; // Assume you have a Constants class with a USERS collection

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UsersApiController (UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDomain userDomain = userMapper.dtoToDomain(userDTO);
        UserDomain createdUser = userService.createUser(userDomain);
        return ResponseEntity.ok(userMapper.domainToDto(createdUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDomain user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(userMapper.domainToDto(user)) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers()
                .stream()
                .map(userMapper::domainToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDomain updatedUser = userService.updateUser(id, userMapper.dtoToDomain(userDTO));
        return updatedUser != null ? ResponseEntity.ok(userMapper.domainToDto(updatedUser)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}