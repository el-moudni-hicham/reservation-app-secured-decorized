package dev.moudni.resourcesservice.web;

import dev.moudni.resourcesservice.entites.Resource;
import dev.moudni.resourcesservice.repository.ResourceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resource-api")
public class ResourceController {
    private ResourceRepository resourceRepository;

    public ResourceController(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @GetMapping("/resources")
    public List<Resource> getResources(){
        return resourceRepository.findAll();
    }

    @GetMapping("/resource/{id}")
    public Resource getResource(@PathVariable Long id){
        return resourceRepository.findById(id).get();
    }
}
