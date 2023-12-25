package com.example.reservationservice.model;

import com.example.reservationservice.enums.ResourceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resource {
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private ResourceType type;
}
