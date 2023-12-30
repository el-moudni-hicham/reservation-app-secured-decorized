package dev.moudni.resourcesservice.repository;

import dev.moudni.resourcesservice.entites.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByNameContains(String keyword);
}
