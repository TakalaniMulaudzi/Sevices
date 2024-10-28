/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.protogen.users.service;

/**
 *
 * @author Dell
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {


    private List<User> users = new ArrayList<>();

  
    public UserServiceImpl() {
       
        User user1 = new User(1L, "John", "Doe", LocalDate.of(1990, 5, 15), "1234567890123");
        User user2 = new User(2L, "Jane", "Smith", LocalDate.of(1985, 10, 22), "9876543210987");
        users.add(user1);
        users.add(user2);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user);
    }

    @Override
    public void removeUser(Long userId) {
        users.removeIf(user -> user.getId().equals(userId));
        System.out.println("User with ID " + userId + " removed.");
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> user = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst();

        return user.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        for (User user : users) {
            if (user.getId().equals(updatedUser.getId())) {
                user.setFirstName(updatedUser.getFirstName());
                user.setLastName(updatedUser.getLastName());
                user.setDateOfBirth(updatedUser.getDateOfBirth());
                user.setRsaId(updatedUser.getRsaId());
                System.out.println("User updated: " + user);
                return;
            }
        }
        System.out.println("User with ID " + updatedUser.getId() + " not found.");
    }

    @Override
    public List<User> searchUsers(String firstName, String lastName, LocalDate dateOfBirth) {
        return users.stream()
                .filter(user -> (firstName == null || user.getFirstName().equalsIgnoreCase(firstName)) &&
                                (lastName == null || user.getLastName().equalsIgnoreCase(lastName)) &&
                                (dateOfBirth == null || user.getDateOfBirth().equals(dateOfBirth)))
                .collect(Collectors.toList());
    }
}