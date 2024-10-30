/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.core.impl;

import java.time.LocalDate;
/**
 *
 * @author Dell
 */import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
import za.co.protogen.adapter.ReservationMapper;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;
import za.co.protogen.domain.models.ReservationDomain;
import za.co.protogen.persistence.models.ReservationEntity;
import za.co.protogen.persistence.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ReservationDomain createReservation(ReservationDomain reservation) {
        logger.info("Creating a new reservation for user ID: {} and car ID: {}", reservation.getUserId(), reservation.getCarId());
        ReservationEntity reservationEntity = reservationMapper.domainToEntity(reservation);
        ReservationEntity savedEntity = reservationRepository.save(reservationEntity);
        logger.info("Reservation created with ID: {}", savedEntity.getId());
        return reservationMapper.entityToDomain(savedEntity);
    }

    @Override
    public ReservationDomain getReservationById(Long id) {
        logger.debug("Fetching reservation with ID: {}", id);
        return reservationRepository.findById(id)
                .map(reservationMapper::entityToDomain)
                .orElse(null);
    }

    public List<ReservationDomain> getAllReservations() {
        logger.debug("Fetching all reservations");
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    public ReservationDomain updateReservation(Long id, ReservationDomain reservation) {
        logger.info("Updating reservation with ID: {}", id);
        if (reservationRepository.existsById(id)) {
            reservation.setId(id);
            ReservationEntity updatedEntity = reservationRepository.save(reservationMapper.domainToEntity(reservation));
            logger.info("Reservation updated with new details: {}", reservation);
            return reservationMapper.entityToDomain(updatedEntity);
        } else {
            logger.warn("Reservation with ID {} not found", id);
            return null;
        }
    }

    public void deleteReservation(Long id) {
        logger.warn("Deleting reservation with ID: {}", id);
        reservationRepository.deleteById(id);
        logger.info("Reservation with ID {} deleted", id);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeReservation(Long reservationId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Reservation> searchReservations(Long userId, Long carId, LocalDate fromDate, LocalDate toDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}