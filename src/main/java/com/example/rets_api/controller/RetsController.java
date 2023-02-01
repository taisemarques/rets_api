package com.example.rets_api.controller;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.repository.PropertyFilter;
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

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getPropertiesByParams(@RequestBody PropertyFilter propertyFilter) {
        return ResponseEntity.ok(propertyService.getPropertiesByParams(propertyFilter));
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<PropertyDTO> getBooksById(@PathVariable("id") Long idproperty){
        return ResponseEntity.ok(propertyService.getPropertyById(idproperty));
    }

}
