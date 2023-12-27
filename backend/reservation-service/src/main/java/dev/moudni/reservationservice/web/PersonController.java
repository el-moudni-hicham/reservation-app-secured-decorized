package dev.moudni.reservationservice.web;

import dev.moudni.reservationservice.entites.Person;
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
@RequestMapping("/person-api")
public class PersonController {
    private PersonRepository personRepository;
    private ReservationRepository reservationRepository;
    private ResourceFeign resourceFeign;

    public PersonController(PersonRepository personRepository, ReservationRepository reservationRepository, ResourceFeign resourceFeign) {
        this.personRepository = personRepository;
        this.reservationRepository = reservationRepository;
        this.resourceFeign = resourceFeign;
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        List<Person> personList = personRepository.findAll();
        personList.forEach(person -> {
            List<Reservation> reservations = reservationRepository.findByPerson(person);
            reservations.forEach(reservation -> {
                reservation.setResource(resourceFeign.getResourcer(reservation.getIdResource()));
            });
            person.setReservations(reservations);
        });
        return personList;
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id) {
        Person person = personRepository.findById(id).get();
        List<Reservation> reservations = reservationRepository.findByPerson(person);
        reservations.forEach(reservation -> {
            reservation.setResource(resourceFeign.getResourcer(reservation.getIdResource()));
        });
        person.setReservations(reservations);
        return person;
    }

}
