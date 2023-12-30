package dev.moudni.resourcesservice.web;

import dev.moudni.resourcesservice.dtos.ResourceResponseDTO;
import dev.moudni.resourcesservice.exceptions.ResourceNotFoundException;
import dev.moudni.resourcesservice.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource-api")
public class ResourceController {
    private ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/resources")
    public List<ResourceResponseDTO> getResources(){
        return resourceService.getResources();
    }

    @GetMapping("/resources/search")
    public List<ResourceResponseDTO> searchResources(@RequestParam(name = "keyword", defaultValue = "") String keyword){
        return resourceService.serchResources("%"+keyword+"%");
    }
    @GetMapping("/resources/{id}")
    public ResponseEntity<?> getResource(@PathVariable Long id){
        try {
            ResourceResponseDTO resourceResponseDTO = resourceService.getResourceById(id);
            return ResponseEntity.ok(resourceResponseDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
