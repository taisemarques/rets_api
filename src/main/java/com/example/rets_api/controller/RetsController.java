package com.example.rets_api.controller;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.resource.PropertyFilter;
import com.example.rets_api.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping(value = {"/properties"})
public class RetsController {

    private PropertyService propertyService;

    public RetsController(PropertyService propertyService){
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<Long> createProperty(@RequestBody PropertyDTO property){
            return new ResponseEntity(propertyService.createProperty(property),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getPropertiesByParams(PropertyFilter filter) {
        List<PropertyDTO> propertyDTOList = propertyService.getPropertiesByParams(filter);
        return handleResponse(propertyDTOList);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<PropertyDTO> getPropertiesById(@PathVariable("id") Long propertyId){
        PropertyDTO propertyDTO = propertyService.getPropertyById(propertyId);
        return handleResponse(propertyDTO);
    }

    private ResponseEntity<PropertyDTO> handleResponse(PropertyDTO propertyDTO){
        if(isNull(propertyDTO)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(propertyDTO);
    }

    private ResponseEntity<List<PropertyDTO>> handleResponse(List<PropertyDTO> propertyDTOList){
        if(isEmpty(propertyDTOList)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(propertyDTOList);
    }

}
