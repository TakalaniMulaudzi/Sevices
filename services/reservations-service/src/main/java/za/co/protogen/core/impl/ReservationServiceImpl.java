/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.core.impl;

/**
 *
 * @author Dell
 */import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;
import za.co.protogen.utility.Constant;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Override
    public Reservation addReservation(Reservation reservation) {
        Constant.reservations.add(reservation);
        return reservation;  // Return the added reservation
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
    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Optional<Reservation> existingReservation = Constant.reservations.stream()
                .filter(reservation -> reservation.getId().equals(id))
                .findFirst();

        if (existingReservation.isPresent()) {
            Reservation reservation = existingReservation.get();
            reservation.setUserId(updatedReservation.getUserId());
            reservation.setCarId(updatedReservation.getCarId());
            reservation.setFromDate(updatedReservation.getFromDate());
            reservation.setToDate(updatedReservation.getToDate());
            reservation.setPickUpLocation(updatedReservation.getPickUpLocation());
            reservation.setDropOffLocation(updatedReservation.getDropOffLocation());
            return reservation;
        }
        return null;  // Return null if no reservation was found
    }

    @Override
    public List<Reservation> searchReservations(Long userId, Long carId, LocalDate fromDate, LocalDate toDate) {
        return Constant.reservations.stream()
                .filter(reservation -> (userId == null || reservation.getUserId().equals(userId)) &&
                                       (carId == null || reservation.getCarId().equals(carId)) &&
                                       (fromDate == null || !reservation.getFromDate().isBefore(fromDate)) &&
                                       (toDate == null || !reservation.getToDate().isAfter(toDate)))
                .collect(Collectors.toList());
    }
}