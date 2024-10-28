/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.protogen.users.service;

/**
 *
 * @author Dell
 */

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    // Adds a new user to the service
    void addUser(User user);

    // Removes a user from the service
    void removeUser(Long userId);

    // Retrieves a user from the service based on their unique identifier
    User getUserById(Long userId);

    // Retrieves a list of all users in the service
    List<User> getAllUsers();

    // Updates the information or attributes of a user
    void updateUser(Long id, User user);

    // Searches for users based on various criteria (e.g., first name, last name, date of birth)
    List<User> searchUsers(String firstName, String lastName, LocalDate dateOfBirth);
}