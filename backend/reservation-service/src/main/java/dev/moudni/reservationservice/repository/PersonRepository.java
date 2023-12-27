package dev.moudni.reservationservice.repository;

import dev.moudni.reservationservice.entites.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
