package dev.moudni.resourcesservice.service;

import dev.moudni.resourcesservice.dtos.ResourceRequestDTO;
import dev.moudni.resourcesservice.dtos.ResourceResponseDTO;
import dev.moudni.resourcesservice.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResourceService {
    List<ResourceResponseDTO> getResources();
    List<ResourceResponseDTO> serchResources(String keyword);
    ResourceResponseDTO getResourceById(Long id) throws ResourceNotFoundException;

    ResourceResponseDTO saveResource(ResourceRequestDTO resourceRequestDTO);
    ResourceResponseDTO updateResource(ResourceRequestDTO resourceRequestDTO) throws ResourceNotFoundException;
    void deleteResource(Long id) throws ResourceNotFoundException;

}
