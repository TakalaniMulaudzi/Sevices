/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.controller;

/**
 *
 * @author Dell
 */
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.CarMapper;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.services.CarService;
import za.co.protogen.domain.models.CarDomain;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    @Autowired
    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO) {
        CarDomain carDomain = carMapper.dtoToDomain(carDTO);
        CarDomain createdCar = carService.createCar(carDomain);
        return ResponseEntity.ok(carMapper.domainToDto(createdCar));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Long id) {
        CarDomain car = carService.getCarById(id);
        return car != null ? ResponseEntity.ok(carMapper.domainToDto(car)) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> cars = carService.getAllCars()
                .stream()
                .map(carMapper::domainToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cars);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO) {
        CarDomain updatedCar = carService.updateCar(id, carMapper.dtoToDomain(carDTO));
        return updatedCar != null ? ResponseEntity.ok(carMapper.domainToDto(updatedCar)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}