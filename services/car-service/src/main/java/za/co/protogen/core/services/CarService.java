/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.protogen.core.services;

import java.util.List;
import za.co.protogen.domain.models.CarDomain;

/**
 *
 * @author Dell
 */
public interface CarService {
      CarDomain createCar(CarDomain car);
    CarDomain getCarById(Long id);
    List<CarDomain> getAllCars();
    CarDomain updateCar(Long id, CarDomain car);
    void deleteCar(Long id);
}
