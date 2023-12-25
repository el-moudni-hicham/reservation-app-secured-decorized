package com.example.reservationservice.repository;

import com.example.reservationservice.entites.Person;
import com.example.reservationservice.entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
