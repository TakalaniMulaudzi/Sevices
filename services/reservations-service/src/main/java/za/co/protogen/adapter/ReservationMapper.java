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
import za.co.protogen.controller.models.ReservationDTO;
import za.co.protogen.core.domain.models.ReservationDomain;
import za.co.protogen.domain.models.ReservationDomain;
import za.co.protogen.persistence.models.ReservationEntity;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    // Map between DTO and Domain
    ReservationDomain dtoToDomain(ReservationDTO dto);
    ReservationDTO domainToDto(ReservationDomain domain);

    // Map between Domain and Entity
    ReservationEntity domainToEntity(ReservationDomain domain);
    ReservationDomain entityToDomain(ReservationEntity entity);
}
