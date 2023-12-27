package dev.moudni.resourcesservice.mappers;

import dev.moudni.resourcesservice.dtos.ResourceRequestDTO;
import dev.moudni.resourcesservice.dtos.ResourceResponseDTO;
import dev.moudni.resourcesservice.entites.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResourceMapper {
    ResourceMapper MAPPER = Mappers.getMapper(ResourceMapper.class);
    Resource toResource(ResourceRequestDTO resourceRequestDTO);
    ResourceResponseDTO toResourceDTO(Resource resource);
}
