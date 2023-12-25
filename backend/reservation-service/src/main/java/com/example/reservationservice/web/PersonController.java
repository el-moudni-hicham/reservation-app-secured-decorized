package com.example.reservationservice.web;

import com.example.reservationservice.entites.Person;
import com.example.reservationservice.entites.Reservation;
import com.example.reservationservice.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person-api")
public class PersonController {
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        List<Person> personList = personRepository.findAll();
        personList.forEach(person -> {
            List<Reservation> reservations = person.getReservations();
            reservations.forEach(reservation -> {
                reservation.setPerson(personRepository.findById(person.getId()).get());
            });
            person.setReservations(reservations);
        });
        return personList;
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personRepository.findById(id).get();
    }

}
