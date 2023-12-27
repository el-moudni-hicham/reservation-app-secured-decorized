package dev.moudni.resourcesservice.dtos;

import dev.moudni.resourcesservice.enums.ResourceType;
import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class ResourceResponseDTO {
    private Long id;
    private String name;
    private ResourceType type;
}
