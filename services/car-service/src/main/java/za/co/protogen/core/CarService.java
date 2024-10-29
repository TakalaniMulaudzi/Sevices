/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.protogen.core;


import java.util.List;
import za.co.protogen.domain.Car;

/**
 *
 * @author Dell
 */


public interface CarService {

    void addCar(Car car);

    void removeCar(String vin);

    Car getCarById(String vin);

    List<Car> getAllCars();

    List<Car> getCarsByMake(String make);

    List<Car> getCarsByYear(int year);

    List<Car> getCarsByColor(String color);

    Car updateCar(String vin, Car updatedCar);

    double calculateAverageMileage();

    Car findCheapestCar();

    Car findMostExpensiveCar();

    Car findNewestCar();

    Car findOldestCar();

    List<Car> searchCars(String make, String model, double minPrice, double maxPrice, int minYear, int maxYear, String color, int minMileage, int maxMileage);
}