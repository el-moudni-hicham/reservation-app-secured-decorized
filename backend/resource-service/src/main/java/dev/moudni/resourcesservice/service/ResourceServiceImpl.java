package dev.moudni.resourcesservice.service;

import dev.moudni.resourcesservice.dtos.ResourceRequestDTO;
import dev.moudni.resourcesservice.dtos.ResourceResponseDTO;
import dev.moudni.resourcesservice.entites.Resource;
import dev.moudni.resourcesservice.exceptions.ResourceNotFoundException;
import dev.moudni.resourcesservice.mappers.ResourceMapper;
import dev.moudni.resourcesservice.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService{
    private ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<ResourceResponseDTO> getResources() {
        List<Resource> resources = resourceRepository.findAll();
        List<ResourceResponseDTO> resourceResponseDTOS =resources.stream().map(ResourceMapper.MAPPER::toResourceDTO).collect(Collectors.toList());
        return resourceResponseDTOS;
    }

    @Override
    public List<ResourceResponseDTO> serchResources(String keyword) {
        return resourceRepository.findByNameContains(keyword).stream().map(ResourceMapper.MAPPER::toResourceDTO).collect(Collectors.toList());
    }

    @Override
    public ResourceResponseDTO getResourceById(Long id) throws ResourceNotFoundException {
        Resource resource = resourceRepository.findById(id).orElse(null);
        if (resource == null) throw new ResourceNotFoundException(String.format("Resource %s Not Found", id));
        return ResourceMapper.MAPPER.toResourceDTO(resource);
    }

    @Override
    public ResourceResponseDTO saveResource(ResourceRequestDTO resourceRequestDTO) {
        Resource resource = ResourceMapper.MAPPER.toResource(resourceRequestDTO);
        Resource resource1 = resourceRepository.save(resource);
        return ResourceMapper.MAPPER.toResourceDTO(resource1);
    }

    @Override
    public ResourceResponseDTO updateResource(ResourceRequestDTO resourceRequestDTO) throws ResourceNotFoundException {
        Resource resource = resourceRepository.findById(resourceRequestDTO.getId()).orElse(null);
        if (resource == null) throw new ResourceNotFoundException(String.format("Resource %s Not Found", resourceRequestDTO.getId()));
        if (resourceRequestDTO.getName() != null) resource.setName(resourceRequestDTO.getName());
        if (resourceRequestDTO.getType() != null) resource.setType(resourceRequestDTO.getType());

        Resource savedResource = resourceRepository.save(resource);
        return ResourceMapper.MAPPER.toResourceDTO(savedResource);
    }

    @Override
    public void deleteResource(Long id) throws ResourceNotFoundException {
        Resource resource = resourceRepository.findById(id).orElse(null);
        if (resource == null) throw new ResourceNotFoundException(String.format("Resource %s Not Found", id));
        resourceRepository.deleteById(id);
    }
}
