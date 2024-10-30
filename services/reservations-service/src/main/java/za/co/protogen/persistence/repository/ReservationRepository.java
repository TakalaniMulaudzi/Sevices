/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.protogen.persistence.Reservation;
import za.co.protogen.persistence.models.ReservationEntity;

/**
 *
 * @author Dell
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public ReservationEntity save(ReservationEntity reservationEntity);
}
