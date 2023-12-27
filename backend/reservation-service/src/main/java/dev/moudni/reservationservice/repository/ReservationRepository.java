package dev.moudni.reservationservice.repository;

import dev.moudni.reservationservice.entites.Person;
import dev.moudni.reservationservice.entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    public List<Reservation> findByPerson(Person person);
}
