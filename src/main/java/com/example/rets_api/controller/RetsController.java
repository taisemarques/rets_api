package com.example.rets_api.controller;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.resource.PropertyFilter;
import com.example.rets_api.service.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/properties"})
public class RetsController {

    private PropertyService propertyService;

    public RetsController(PropertyService propertyService){
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<Long> createProperty(@RequestBody PropertyDTO property){
        return ResponseEntity.ok(propertyService.createProperty(property));
    }

    @GetMapping(value = "/byFilter")
    public ResponseEntity<List<PropertyDTO>> getPropertiesByParams(@RequestBody PropertyFilter propertyFilter) {
        return ResponseEntity.ok(propertyService.getPropertiesByParams(propertyFilter));
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<PropertyDTO> getPropertyById(@PathVariable("id") Long propertyId){
        return ResponseEntity.ok(propertyService.getPropertyById(propertyId));
    }

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

}
