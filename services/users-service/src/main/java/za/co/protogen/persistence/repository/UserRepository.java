/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.protogen.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.protogen.domain.User;

/**
 *
 * @author Dell
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
