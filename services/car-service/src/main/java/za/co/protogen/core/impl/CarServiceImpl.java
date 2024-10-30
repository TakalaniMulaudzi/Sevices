/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.core.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import za.co.protogen.persistence.repository.CarRepository;
import za.co.protogen.adapter.CarMapper;
import za.co.protogen.core.services.CarService;

import java.util.List;
import java.util.stream.Collectors;
import za.co.protogen.domain.models.CarDomain;
import za.co.protogen.persistence.Models.CarEntity;
/**
 *
 * @author Dell
 */


@Service
public class CarServiceImpl implements CarService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(CarServiceImpl.class);

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public CarDomain createCar(CarDomain car) {
        logger.info("Adding a new car with details: {}", car);
        CarEntity carEntity = carMapper.domainToEntity(car);
        CarEntity savedEntity = carRepository.save(carEntity);
        logger.info("Car added with ID: {}", savedEntity.getId());
        return carMapper.entityToDomain(savedEntity);
    }

    @Override
    public CarDomain getCarById(Long id) {
        logger.debug("Fetching car with ID: {}", id);
        return carRepository.findById(id)
                .map(carMapper::entityToDomain)
                .orElse(null);
    }

    @Override
    public List<CarDomain> getAllCars() {
        logger.debug("Fetching all cars");
        return carRepository.findAll()
                .stream()
                .map(carMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public CarDomain updateCar(Long id, CarDomain car) {
        logger.info("Updating car with ID: {}", id);
        if (carRepository.existsById(id)) {
            car.setId(id);
            CarEntity updatedEntity = carRepository.save(carMapper.domainToEntity(car));
            logger.info("Car updated with new details: {}", car);
            return carMapper.entityToDomain(updatedEntity);
        } else {
            logger.warn("Car with ID {} not found", id);
            return null;
        }
    }

    @Override
    public void deleteCar(Long id) {
        logger.warn("Deleting car with ID: {}", id);
        carRepository.deleteById(id);
        logger.info("Car with ID {} deleted", id);
    }
}