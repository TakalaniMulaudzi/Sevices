/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.controller;

/**
 *
 * @author Dell
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.controller.models.ReservationDTO;
import za.co.protogen.core.domain.models.ReservationDomain;
import za.co.protogen.core.services.ReservationService;
import za.co.protogen.adapter.ReservationMapper;

import java.util.List;
import java.util.stream.Collectors;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.models.ReservationDomain;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        ReservationDomain reservationDomain = reservationMapper.dtoToDomain(reservationDTO);
        ReservationDomain createdReservation = reservationService.createReservation(reservationDomain);
        return ResponseEntity.ok(reservationMapper.domainToDto(createdReservation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        ReservationDomain reservation = reservationService.getReservationById(id);
        return reservation != null ? ResponseEntity.ok(reservationMapper.domainToDto(reservation)) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<ReservationDTO> reservations = reservationService.getAllReservations()
                .stream()
                .map(reservationMapper::domainToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
        ReservationDomain updatedReservation = reservationService.updateReservation(id, reservationMapper.dtoToDomain(reservationDTO));
        return updatedReservation != null ? ResponseEntity.ok(reservationMapper.domainToDto(updatedReservation)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
