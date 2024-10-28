/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.protogen.car.service;

/**
 *
 * @author Dell
 */


import java.util.List;

public interface CarService {
    

    void addCar(Car car);
    
 
    void removeCar(String vin);
    
 
    Car getCarById(String vin);
    

    List<Car> getAllCars();
    
  
    List<Car> getCarsByMake(String make);
 
    List<Car> getCarsByYear(int year);

    List<Car> getCarsByColor(String color);
    
 
   void updateCar(String vin, Car updatedCar);
    

    double calculateAverageMileage();
    
   
    Car findCheapestCar();
    

    Car findMostExpensiveCar();
    
   
    Car findNewestCar();
    
 
    Car findOldestCar();
    

    List<Car> searchCars(String make, String model, double minPrice, double maxPrice, int minYear, int maxYear, String color, int minMileage, int maxMileage);
}