package dev.moudni.resourcesservice.repository;

import dev.moudni.resourcesservice.entites.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
