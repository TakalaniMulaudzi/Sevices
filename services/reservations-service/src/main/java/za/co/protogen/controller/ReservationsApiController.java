/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.controller;

/**
 *
 * @author Dell
 */
import za.co.protogen.domain.Reservation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import za.co.protogen.utility.Constant;



@RestController
@RequestMapping("/reservations")
public class ReservationsApiController {
    private List<Reservation> reservations = Constant.reservations; 

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservations;
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        // Verify userId and carId using RestTemplate
        // If valid, add reservation
        reservations.add(reservation);
        return reservation;
    }

    // Implement other CRUD operations similarly...
}