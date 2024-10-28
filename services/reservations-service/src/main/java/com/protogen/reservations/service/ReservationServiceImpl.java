/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.protogen.reservations.service;

/**
 *
 * @author Dell
 */
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationServiceImpl implements ReservationService {

    @Override
    public void addReservation(Reservation reservation) {
        Constant.reservations.add(reservation);
    }

    @Override
    public void removeReservation(Long id) {
        Constant.reservations.removeIf(reservation -> reservation.getId().equals(id));
    }

    @Override
    public Reservation getReservationById(Long id) {
        Optional<Reservation> reservation = Constant.reservations.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
        return reservation.orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return Constant.reservations;
    }

    @Override
    public void updateReservation(Reservation updatedReservation) {
        Constant.reservations.stream()
                .filter(reservation -> reservation.getId().equals(updatedReservation.getId()))
                .forEach(reservation -> {
                    reservation.setUserId(updatedReservation.getUserId());
                    reservation.setCarId(updatedReservation.getCarId());
                    reservation.setFromDate(updatedReservation.getFromDate());
                    reservation.setToDate(updatedReservation.getToDate());
                    reservation.setPickUpLocation(updatedReservation.getPickUpLocation());
                    reservation.setDropOffLocation(updatedReservation.getDropOffLocation());
                });
    }

    public List<Reservation> searchReservations(Long userId, Long carId, String pickUpLocation, String dropOffLocation) {
        return Constant.reservations.stream()
                .filter(reservation -> (userId == null || reservation.getUserId().equals(userId)) &&
                                       (carId == null || reservation.getCarId().equals(carId)) &&
                                       (pickUpLocation == null || reservation.getPickUpLocation().equalsIgnoreCase(pickUpLocation)) &&
                                       (dropOffLocation == null || reservation.getDropOffLocation().equalsIgnoreCase(dropOffLocation)))
                .collect(Collectors.toList());
    }

  
}