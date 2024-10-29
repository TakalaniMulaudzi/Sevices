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
import za.co.protogen.domain.Car;
import za.co.protogen.utility.Constant;

@RestController
@RequestMapping("/cars")
public class CarsApiController {
    private List<Car> cars = Constant.cars; // Assume you have a Constants class with a CARS collection

    @GetMapping
    public List<Car> getAllCars() {
        return cars;
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        cars.add(car);
        return car;
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable String id) {
        return cars.stream().filter(car -> car.getVin().equals(id)).findFirst().orElse(null);
    }

    // Implement other CRUD operations similarly...
}