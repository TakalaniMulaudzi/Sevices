/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.protogen.adapter;

/**
 *
 * @author Dell
 */
import org.mapstruct.Mapper;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.domain.models.CarDomain;
import za.co.protogen.persistence.Models.CarEntity;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDomain dtoToDomain(CarDTO dto);
    CarDTO domainToDto(CarDomain domain);
    CarEntity domainToEntity(CarDomain domain);
    CarDomain entityToDomain(CarEntity entity);
}