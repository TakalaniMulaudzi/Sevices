/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen;

/**
 *
 * @author Dell
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return ResponseEntity.ok(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCar(@PathVariable String id) {
        carService.removeCar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable String id) {
        Car car = carService.getCarById(id);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable String id, @RequestBody Car car) {
        Car updatedCar = carService.updateCar(id, car);
        return updatedCar != null ? ResponseEntity.ok(updatedCar) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Car>> searchCars(
            @RequestParam(required = false) Optional<String> make,
            @RequestParam(required = false) Optional<String> model,
            @RequestParam(required = false) Optional<Double> minPrice,
            @RequestParam(required = false) Optional<Double> maxPrice,
            @RequestParam(required = false) Optional<Integer> minYear,
            @RequestParam(required = false) Optional<Integer> maxYear,
            @RequestParam(required = false) Optional<String> color,
            @RequestParam(required = false) Optional<Integer> minMileage,
            @RequestParam(required = false) Optional<Integer> maxMileage) {

        List<Car> cars = carService.searchCars(
                make.orElse(null),
                model.orElse(null),
                minPrice.orElse(0.0),
                maxPrice.orElse(Double.MAX_VALUE),
                minYear.orElse(0),
                maxYear.orElse(Integer.MAX_VALUE),
                color.orElse(null),
                minMileage.orElse(0),
                maxMileage.orElse(Integer.MAX_VALUE)
        );

        return ResponseEntity.ok(cars);
    }
}