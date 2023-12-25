package com.example.reservationservice.web;

import com.example.reservationservice.entites.Reservation;
import com.example.reservationservice.feign.ResourceFeign;
import com.example.reservationservice.repository.PersonRepository;
import com.example.reservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation-api")
public class ReservationController {
    private ReservationRepository reservationRepository;
    private PersonRepository personRepository;

    @Autowired
    private ResourceFeign resourceFeign;

    public ReservationController(ReservationRepository reservationRepository, PersonRepository personRepository) {
        this.reservationRepository = reservationRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        reservations.forEach(reservation -> {
            reservation.setResource(resourceFeign.getResourcer(reservation.getIdResource()));
        });
        return reservations;
    }

    @GetMapping("/reservation/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        Reservation reservation = reservationRepository.findById(id).get();
        reservation.setResource(resourceFeign.getResourcer(reservation.getIdResource()));
        return reservation;
    }
}
