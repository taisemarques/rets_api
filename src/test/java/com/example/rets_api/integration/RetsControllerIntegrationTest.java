package com.example.rets_api.integration;

import com.example.rets_api.RetsApiApplication;
import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.PropertyPatchDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.lang.reflect.Type;
import java.util.List;

import static com.example.rets_api.utils.DtoUtilsTest.createPropertyDTOWithBasicFields;
import static com.example.rets_api.utils.DtoUtilsTest.createPropertyPatchDTOWithBasicFields;
import static com.example.rets_api.utils.FilterUtilsTest.createURLVariablesOperatorAgeBedroomBathroom;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = RetsApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RetsControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void creatingProperty() {
        //Creating objects
        PropertyDTO propertyDTORequest = createPropertyDTOWithBasicFields();
        String URL = "http://localhost:" + port + "/properties";

        //Request
        ResponseEntity<Long> responseEntity = this.restTemplate
                .postForEntity(URL, propertyDTORequest, Long.class);

        //Validation
        assertEquals(201, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void getPropertyById_notFound() {
        //Creating objects
        String URL = "http://localhost:" + port + "/properties/123456";

        //Request
        ResponseEntity<PropertyDTO> responseEntityGet = this.restTemplate
                .getForEntity(URL, PropertyDTO.class);

        //Validation
        assertEquals(404, responseEntityGet.getStatusCodeValue());
    }

    @Test
    public void getPropertyById() {
        //Preparing scenario: Adding a property
        PropertyDTO propertyDTORequest = createPropertyDTOWithBasicFields();
        String URL = "http://localhost:" + port + "/properties";
        ResponseEntity<Long> responseEntityPost = this.restTemplate
                .postForEntity(URL, propertyDTORequest, Long.class);
        assertEquals(201, responseEntityPost.getStatusCodeValue());

        //Creating objects
        String URLWithID = URL
                    .concat("/")
                    .concat(String.valueOf(responseEntityPost.getBody()));

        //Request
        ResponseEntity<PropertyDTO> responseEntityGet = this.restTemplate
                .getForEntity(URLWithID, PropertyDTO.class);

        //Validation
        assertEquals(200, responseEntityGet.getStatusCodeValue());
        assertEquals(propertyDTORequest, responseEntityGet.getBody());
    }

    @Test
    public void getPropertiesByParams_Operator() {
        //Preparing scenario: Adding a property
        PropertyDTO propertyDTORequest = createPropertyDTOWithBasicFields();
        String URL = "http://localhost:" + port + "/properties";
        ResponseEntity<Long> responseEntityPost = this.restTemplate
                .postForEntity(URL, propertyDTORequest, Long.class);
        assertEquals(201, responseEntityPost.getStatusCodeValue());

        //Creating objects
        String urlVariables = createURLVariablesOperatorAgeBedroomBathroom();

        //Request
        ResponseEntity<String> responseEntityGet = this.restTemplate
                .getForEntity(URL+urlVariables, String.class);

        //Validation
        assertEquals(200, responseEntityGet.getStatusCodeValue());
        assertEquals(propertyDTORequest, getPropertyDTOFromResponse(responseEntityGet, 0));
    }

    @Test
    public void deletetPropertyById() {
        //Preparing scenario: Adding a property
        PropertyDTO propertyDTORequest = createPropertyDTOWithBasicFields();
        String URL = "http://localhost:" + port + "/properties";
        ResponseEntity<Long> responseEntityPost = this.restTemplate
                .postForEntity(URL, propertyDTORequest, Long.class);
        assertEquals(201, responseEntityPost.getStatusCodeValue());

        //Creating objects
        String URLWithID = URL
                .concat("/")
                .concat(String.valueOf(responseEntityPost.getBody()));

        //Request
        this.restTemplate.delete(URLWithID);

        //Request
        ResponseEntity<PropertyDTO> responseEntityGetAgain = this.restTemplate
                .getForEntity(URLWithID, PropertyDTO.class);

        assertEquals(404, responseEntityGetAgain.getStatusCodeValue());
    }

    private PropertyDTO getPropertyDTOFromResponse(ResponseEntity<String> response, int propertyIndex){
        Gson g = new Gson();
        Type collectionType = new TypeToken<List<PropertyDTO>>(){}.getType();
        List<PropertyDTO> propertyDTOList = g.fromJson(response.getBody(), collectionType);
        return propertyDTOList.get(propertyIndex);
    }

    private HttpEntity<String> getStringFromPropertyPatchDTO(PropertyPatchDTO propertyPatchDTO){
        Gson g = new Gson();
        String propertyJson = g.toJson(propertyPatchDTO);

        return new HttpEntity<String>(propertyJson);
    }

    @Test
    public void patchProperty() {
        //Creating objects
        PropertyDTO propertyDTORequest = createPropertyDTOWithBasicFields();
        PropertyPatchDTO propertyPatchDTORequest = createPropertyPatchDTOWithBasicFields();

        String URL = "http://localhost:" + port + "/properties";


        //Request
        ResponseEntity<Long> responseEntity = this.restTemplate
                .postForEntity(URL, propertyDTORequest, Long.class);

        //Creating objects
        String URLWithID = URL
                .concat("/")
                .concat(String.valueOf(responseEntity.getBody()));


        ResponseEntity<Long> responsePatchEntity = this.restTemplate
                .exchange(URLWithID,HttpMethod.PATCH, getStringFromPropertyPatchDTO(propertyPatchDTORequest), Long.class);

        //Validation
        assertEquals(200, responsePatchEntity.getStatusCodeValue());
        assertNotNull(responsePatchEntity.getBody());


        //Request
        ResponseEntity<PropertyDTO> responseEntityGet = this.restTemplate
                .getForEntity(URLWithID, PropertyDTO.class);

        //Validation
//        assertEquals(responsePatchEntity, responseEntityGet.getBody());
        //verify if the entity in get is the same as dto patch

    }

    @Test
    public void patchPropertyNotExcist() {
        //Creating objects
        PropertyPatchDTO propertyPatchDTORequest = createPropertyPatchDTOWithBasicFields();

        String URL = "http://localhost:" + port + "/properties";

        //Creating objects
        String URLWithID = URL
                .concat("/")
                .concat(String.valueOf(1));


        ResponseEntity<Long> responsePatchEntity = this.restTemplate
                .exchange(URLWithID,HttpMethod.PATCH, getStringFromPropertyPatchDTO(propertyPatchDTORequest), Long.class);

        //Validation
        assertEquals(404, responsePatchEntity.getStatusCodeValue());


    }

}
