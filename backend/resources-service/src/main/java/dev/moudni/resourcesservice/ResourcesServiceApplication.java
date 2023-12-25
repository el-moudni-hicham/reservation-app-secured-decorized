package dev.moudni.resourcesservice;

import dev.moudni.resourcesservice.entites.Resource;
import dev.moudni.resourcesservice.enums.ResourceType;
import dev.moudni.resourcesservice.repository.ResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResourcesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourcesServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ResourceRepository resourceRepository){
		return args -> {
			List<Resource> resources = List.of(
					Resource.builder()
							.name("RES1")
							.type(ResourceType.MATERIEL_INF0)
							.build(),
					Resource.builder()
							.name("RES2")
							.type(ResourceType.MATERIEL_AUDIO_VUSUEL)
							.build(),
					Resource.builder()
							.name("RES3")
							.type(ResourceType.MATERIEL_INF0)
							.build(),
					Resource.builder()
							.name("RES4")
							.type(ResourceType.MATERIEL_AUDIO_VUSUEL)
							.build()
			);

			resourceRepository.saveAll(resources);
		};
	}
}
