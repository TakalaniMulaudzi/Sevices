/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.protogen.persistence.repository;

/**
 *
 * @author Dell
 */
import za.co.protogen.persistence.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.protogen.persistence.Models.CarEntity;

public interface CarRepository extends JpaRepository<Car, Long> {

    public CarEntity save(CarEntity carEntity);
}