package com.example.reservationservice.repository;

import com.example.reservationservice.entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
}
