package dev.moudni.reservationservice.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity @Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String function;

    @OneToMany(mappedBy = "person")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Reservation> reservations;
}
