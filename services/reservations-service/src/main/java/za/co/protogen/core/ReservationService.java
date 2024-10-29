/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.protogen.core;

/**
 *
 * @author Dell
 */import java.time.LocalDate;
import java.util.List;
import za.co.protogen.domain.Reservation;

public interface ReservationService {

    // Adds a new reservation and returns the created reservation object
    Reservation addReservation(Reservation reservation);

    // Removes a reservation by its unique identifier
    void removeReservation(Long reservationId);

    // Retrieves a reservation based on its unique identifier
    Reservation getReservationById(Long reservationId);

    // Retrieves a list of all reservations
    List<Reservation> getAllReservations();

    // Updates an existing reservation and returns the updated reservation
    Reservation updateReservation(Long id, Reservation reservation);

    // Searches for reservations based on user ID, car ID, and date range
    List<Reservation> searchReservations(Long userId, Long carId, LocalDate fromDate, LocalDate toDate);
}