/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.protogen.core.impl;

import java.util.List;
import za.co.protogen.persistence.models.UserDomain;

/**
 *
 * @author Dell
 */
public interface UserService {
   UserDomain createUser(UserDomain user);
    UserDomain getUserById(Long id);
    List<UserDomain> getAllUsers();
    UserDomain updateUser(Long id, UserDomain user);
    void deleteUser(Long id);  
}
