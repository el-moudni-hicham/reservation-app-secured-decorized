package com.example.reservationservice.feign;

import com.example.reservationservice.model.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RESOURCE-SERVICE") //, configuration = FeignInterceptor.class
public interface ResourceFeign {
    @GetMapping("/resource-api/resource/{id}")
    Resource getResourcer(@PathVariable Long id);

    @GetMapping("/resource-api/resources")
    List<Resource> getResources();
}
