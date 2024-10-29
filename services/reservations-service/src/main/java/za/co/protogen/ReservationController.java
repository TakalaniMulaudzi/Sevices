/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen;

/**
 *
 * @author Dell
 */import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Endpoint to add a new reservation
    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.addReservation(reservation);
        return ResponseEntity.ok(createdReservation);
    }

    // Endpoint to delete a reservation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeReservation(@PathVariable Long id) {
        reservationService.removeReservation(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to get a reservation by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint to get all reservations
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    // Endpoint to update an existing reservation by ID
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        Reservation updatedReservation = reservationService.updateReservation(id, reservation);
        if (updatedReservation != null) {
            return ResponseEntity.ok(updatedReservation);
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint to search reservations based on userId, carId, fromDate, and toDate
    @GetMapping("/search")
    public ResponseEntity<List<Reservation>> searchReservations(@RequestParam(required = false) Long userId,
                                                                @RequestParam(required = false) Long carId,
                                                                @RequestParam(required = false) String fromDate,
                                                                @RequestParam(required = false) String toDate) {
        LocalDate parsedFromDate = null;
        LocalDate parsedToDate = null;

        // Parsing date strings to LocalDate
        try {
            if (fromDate != null && !fromDate.isEmpty()) {
                parsedFromDate = LocalDate.parse(fromDate);
            }
            if (toDate != null && !toDate.isEmpty()) {
                parsedToDate = LocalDate.parse(toDate);
            }
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body(null); // Return bad request if date parsing fails
        }

        List<Reservation> reservations = reservationService.searchReservations(userId, carId, parsedFromDate, parsedToDate);
        return ResponseEntity.ok(reservations);
    }
}