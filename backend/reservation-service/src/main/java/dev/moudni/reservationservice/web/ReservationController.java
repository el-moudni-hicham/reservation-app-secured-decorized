package dev.moudni.reservationservice.web;

import dev.moudni.reservationservice.entites.Reservation;
import dev.moudni.reservationservice.feign.ResourceFeign;
import dev.moudni.reservationservice.repository.PersonRepository;
import dev.moudni.reservationservice.repository.ReservationRepository;
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
    private ResourceFeign resourceFeign;

    public ReservationController(ReservationRepository reservationRepository, PersonRepository personRepository, ResourceFeign resourceFeign) {
        this.reservationRepository = reservationRepository;
        this.personRepository = personRepository;
        this.resourceFeign = resourceFeign;
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        reservations.forEach(reservation -> {
            reservation.setResource(resourceFeign.getResourcer(reservation.getIdResource()));
            reservation.setPerson(personRepository.findById(reservation.getPerson().getId()).get());
        });
        return reservations;
    }

    @GetMapping("/reservation/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        Reservation reservation = reservationRepository.findById(id).get();
        reservation.setResource(resourceFeign.getResourcer(reservation.getIdResource()));
        reservation.setPerson(personRepository.findById(reservation.getPerson().getId()).get());
        return reservation;
    }
}
