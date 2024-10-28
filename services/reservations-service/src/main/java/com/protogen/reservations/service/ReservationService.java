/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.protogen.reservations.service;

/**
 *
 * @author Dell
 */
import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    void addReservation(Reservation reservation);

    void removeReservation(Long reservationId);

    Reservation getReservationById(Long reservationId);

    List<Reservation> getAllReservations();

    void updateReservation(Reservation updatedReservation);

    List<Reservation> searchReservations(Long userId, Long carId, String fromDate, String toDate);

    public Reservation updateReservation(Long id, Reservation reservation);
}