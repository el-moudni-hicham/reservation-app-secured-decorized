package com.example.reservationservice;

import com.example.reservationservice.entites.Person;
import com.example.reservationservice.entites.Reservation;
import com.example.reservationservice.repository.PersonRepository;
import com.example.reservationservice.repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ReservationRepository reservationRepository, PersonRepository personRepository) {
		return args -> {
			List<Person> people = List.of(
					Person.builder()
							.name("PERSON1")
							.email("per1@gmail.com")
							.function("FUNCTION1")
							.build(),
					Person.builder()
							.name("PERSON2")
							.email("per2@gmail.com")
							.function("FUNCTION2")
							.build(),
					Person.builder()
							.name("PERSON3")
							.email("per3@gmail.com")
							.function("FUNCTION3")
							.build(),
					Person.builder()
							.name("PERSON4")
							.email("per4@gmail.com")
							.function("FUNCTION4")
							.build()
			);

			personRepository.saveAll(people);

			List<Reservation> reservations = List.of(
					Reservation.builder()
							.context("CONTEXT1")
							.name("RESERVATION1")
							.idResource(1L)
							.person(people.get(0))
							.duration(4)
							.date(new Date())
							.build(),
					Reservation.builder()
							.context("CONTEXT2")
							.name("RESERVATION2")
							.idResource(2L)
							.person(people.get(1))
							.duration(6)
							.date(new Date())
							.build(),
					Reservation.builder()
							.context("CONTEXT3")
							.name("RESERVATION3")
							.person(people.get(2))
							.idResource(3L)
							.duration(8)
							.date(new Date())
							.build(),
					Reservation.builder()
							.context("CONTEXT4")
							.name("RESERVATION4")
							.person(people.get(3))
							.idResource(1L)
							.duration(2)
							.date(new Date())
							.build()
			);

			reservationRepository.saveAll(reservations);

		};
	}
}
