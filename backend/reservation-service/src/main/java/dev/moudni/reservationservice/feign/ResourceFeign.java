package dev.moudni.reservationservice.feign;

import dev.moudni.reservationservice.enums.ResourceType;
import dev.moudni.reservationservice.model.Resource;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RESOURCE-SERVICE") //, configuration = FeignInterceptor.class
public interface ResourceFeign {
    @GetMapping("/resource-api/resource/{id}")
    @CircuitBreaker(name = "resource", fallbackMethod = "getDefaultResource")
    Resource getResourcer(@PathVariable Long id);
    @GetMapping("/resource-api/resources")
    @Retry(name = "resources", fallbackMethod = "getDefaultResources")
    List<Resource> getResources();

    default Resource getDefaultResource(Long id, Exception e){
        return Resource.builder()
                .id(id)
                .name("Default Resource")
                .type(ResourceType.DEFAULT)
                .build();
    }
    default List<Resource> getDefaultResources(){
        return List.of();
    }
}
