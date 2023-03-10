package com.example.rets_api.controller;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.PropertyPatchDTO;
import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.resource.PropertyFilter;
import com.example.rets_api.service.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping(value = {"/properties"})
@Api(value = "Property Management", protocols = "http")
public class RetsController {

    private PropertyService propertyService;

    public RetsController(PropertyService propertyService){
        this.propertyService = propertyService;
    }

    @ApiOperation(value = "Create a property with the body")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Property created", response = Long.class),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> createProperty(@RequestBody PropertyDTO property){
        return handleCreateResponse(propertyService.createProperty(property));
    }

    @ApiOperation(value = "Search for a list of properties by filters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Property founded", response = PropertyDTO.class),
            @ApiResponse(code = 404, message = "Property not founded"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getPropertiesByParams(PropertyFilter filter) {
        List<PropertyDTO> propertyDTOList = propertyService.getPropertiesByParams(filter);
        return handleResponse(propertyDTOList);
    }

    @ApiOperation(value = "Search for a property by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Property founded", response = PropertyDTO.class),
            @ApiResponse(code = 404, message = "Property not founded"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @GetMapping(value="/{id}")
    public ResponseEntity<PropertyDTO> getPropertiesById(@PathVariable("id") Long propertyId){
        PropertyDTO propertyDTO = propertyService.getPropertyById(propertyId);
        return handleResponse(propertyDTO);
    }

    @ApiOperation(value = "Delete a property by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Property deleted", response = PropertyDTO.class),
            @ApiResponse(code = 404, message = "Property not founded"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @DeleteMapping(value="/{id}")
    public ResponseEntity<PropertyDTO> deletePropertiesById(@PathVariable("id") Long propertyId){
        PropertyDTO propertyDTO = propertyService.deletePropertyById(propertyId);
        return handleResponse(propertyDTO);
    }

    @ApiOperation(value = "Patch basic fields in a property by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Property patched", response = Long.class ),
            @ApiResponse(code = 404, message = "Property not founded"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @PatchMapping(value="/{id}")
    public ResponseEntity<PropertyPatchDTO> patchProperty(@PathVariable("id") Long propertyId, @RequestBody PropertyPatchDTO propertyPatchDTO){
        return handleResponse(propertyService.patchProperty(propertyId, propertyPatchDTO));
    }

    @ApiOperation(value = "Patch schoolList in a property by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Property patched", response = Long.class ),
            @ApiResponse(code = 404, message = "Property not founded"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @PatchMapping(value="/{idProperty}/schoolList")
    public ResponseEntity<List<SchoolDTO>> patchSchoolList(@PathVariable("idProperty") Long propertyId, @RequestBody List<SchoolDTO> schoolListDTO){
        return handleResponse(propertyService.patchProperty(propertyId, schoolListDTO));
    }

    @ApiOperation(value = "Patch a School in a property by propertyId and by schoolID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Property patched", response = Long.class ),
            @ApiResponse(code = 404, message = "Property not founded"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @PatchMapping(value="/{idProperty}/school/{idSchool}")
    public ResponseEntity<SchoolDTO> patchSchool(@PathVariable("idProperty") Long propertyId, @PathVariable("idSchool") Long schoolId, @RequestBody SchoolDTO schoolToPatch){
        return handleResponse(propertyService.patchSchool(propertyId, schoolId, schoolToPatch));
    }

    private <T> ResponseEntity<T> handleResponse(T responseDTO){
        if(isNull(responseDTO)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(responseDTO);
    }

    private <T> ResponseEntity<List<T>> handleResponse(List<T> responseListDTO){
        if(isEmpty(responseListDTO)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(responseListDTO);
    }

    private ResponseEntity<Long> handleCreateResponse(Long id){
        if(isNull(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(id, HttpStatus.CREATED);
    }

}
