package dev.moudni.reservationservice.entites;

import dev.moudni.reservationservice.model.Resource;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String context;
    private LocalDate date;
    private double duration;

    @ManyToOne
    private Person person;

    private Long idResource;
    @Transient
    private Resource resource;
}
