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
import org.mapstruct.Mapping;
import za.co.protogen.persistence.models.UserDTO;
import za.co.protogen.persistence.models.UserDomain;
import za.co.protogen.persistence.models.UserEntity;
import za.co.protogen.persistence.repository.User;


@Mapper(componentModel = "spring")
public interface UserMapper {

    // Map between DTO and Domain
    UserDomain dtoToDomain(UserDTO dto);
    UserDTO domainToDto(UserDomain domain);

    // Map between Domain and Entity
    UserEntity domainToEntity(UserDomain domain);
    UserDomain entityToDomain(User entity);
}