/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.protogen.car.service;

/**
 *
 * @author Dell
 */
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    // Adds a new car to the service
    @Override
    public void addCar(Car car) {
        Constant.cars.add(car);
    }

    @Override
    public void removeCar(String vin) {
        Constant.cars.removeIf(car -> car.getVin().equals(vin));
    }


    @Override
    public Car getCarById(String vin) {
        return Constant.cars.stream()
                .filter(car -> car.getVin().equals(vin))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return Constant.cars;
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        return Constant.cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase(make))
                .collect(Collectors.toList());
    }

  
    @Override
    public List<Car> getCarsByYear(int year) {
        return Constant.cars.stream()
                .filter(car -> car.getYear() == year)
                .collect(Collectors.toList());
    }


    @Override
    public List<Car> getCarsByColor(String color) {
        return Constant.cars.stream()
                .filter(car -> car.getColor().equals(color))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param vin
     * @param updatedCar
     * @return 
     */
    @Override
    public Car updateCar(String vin, Car updatedCar) {
        Optional<Car> carOptional = Constant.cars.stream()
                .filter(car -> car.getVin().equals(vin))
                .findFirst();
        carOptional.ifPresent(car -> {
            car.setMake(updatedCar.getMake());
            car.setModel(updatedCar.getModel());
            car.setYear(updatedCar.getYear());
            car.setColor(updatedCar.getColor());
            car.setEngine(updatedCar.getEngine());
            car.setTransmission(updatedCar.getTransmission());
            car.setFuelType(updatedCar.getFuelType());
            car.setMileage(updatedCar.getMileage());
            car.setPrice(updatedCar.getPrice());
            car.setOwnerId(updatedCar.getOwnerId());
            car.setFeatures(updatedCar.getFeatures());
        });
     
    }

    @Override
    public double calculateAverageMileage() {
        return Constant.cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);
    }

    @Override
    public Car findCheapestCar() {
        return Constant.cars.stream()
                .min(Comparator.comparingDouble(Car::getPrice))
                .orElse(null);
    }


    @Override
    public Car findMostExpensiveCar() {
        return Constant.cars.stream()
                .max(Comparator.comparingDouble(Car::getPrice))
                .orElse(null);
    }

    // Finds the newest car based on the manufacturing year
    @Override
    public Car findNewestCar() {
        return Constant.cars.stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    // Finds the oldest car based on the manufacturing year
    @Override
    public Car findOldestCar() {
        return Constant.cars.stream()
                .min(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    // Searches for cars based on various criteria such as make, model, price range, etc.
    @Override
    public List<Car> searchCars(String make, String model, double minPrice, double maxPrice, int minYear, int maxYear, String color, int minMileage, int maxMileage) {
        return Constant.cars.stream()
                .filter(car -> (make == null || car.getMake().equalsIgnoreCase(make)))
                .filter(car -> (model == null || car.getModel().equalsIgnoreCase(model)))
                .filter(car -> (minPrice <= car.getPrice() && car.getPrice() <= maxPrice))
                .filter(car -> (minYear <= car.getYear() && car.getYear() <= maxYear))
                .filter(car -> (color == null || car.getColor().equals(color)))
                .filter(car -> (minMileage <= car.getMileage() && car.getMileage() <= maxMileage))
                .collect(Collectors.toList());
    }
}