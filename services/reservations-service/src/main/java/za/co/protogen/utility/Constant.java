/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.utility;

/**
 *
 * @author Dell
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import za.co.protogen.domain.Reservation;

public class Constant {

    public static List<Reservation> reservations = new ArrayList<>();

    static {
        // Add mock data for reservations
        Reservation reservation1 = new Reservation();
        reservation1.setId(1L);
        reservation1.setUserId(123L);
        reservation1.setCarId(101L);
        reservation1.setFromDate(LocalDate.of(2023, 6, 15));
        reservation1.setToDate(LocalDate.of(2023, 6, 20));
        reservation1.setPickUpLocation("Johannesburg");
        reservation1.setDropOffLocation("Pretoria");
        reservations.add(reservation1);

        Reservation reservation2 = new Reservation();
        reservation2.setId(2L);
        reservation2.setUserId(456L);
        reservation2.setCarId(102L);
        reservation2.setFromDate(LocalDate.of(2023, 7, 10));
        reservation2.setToDate(LocalDate.of(2023, 7, 15));
        reservation2.setPickUpLocation("Cape Town");
        reservation2.setDropOffLocation("Durban");
        reservations.add(reservation2);

        Reservation reservation3 = new Reservation();
        reservation3.setId(3L);
        reservation3.setUserId(789L);
        reservation3.setCarId(103L);
        reservation3.setFromDate(LocalDate.of(2023, 8, 1));
        reservation3.setToDate(LocalDate.of(2023, 8, 5));
        reservation3.setPickUpLocation("Port Elizabeth");
        reservation3.setDropOffLocation("East London");
        reservations.add(reservation3);

        // Add more mock data as needed
    }
}
