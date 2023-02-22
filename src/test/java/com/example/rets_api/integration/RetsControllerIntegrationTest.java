package com.example.rets_api.integration;

import com.example.rets_api.RetsApiApplication;
import com.example.rets_api.dto.PropertyDTO;
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
import static org.junit.Assert.assertEquals;

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
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(Long.valueOf(1), responseEntity.getBody());
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
        assertEquals(200, responseEntityPost.getStatusCodeValue());

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
    public void getPropertiesByParams() {
        //Preparing scenario: Adding a property
        PropertyDTO propertyDTORequest = createPropertyDTOWithBasicFields();
        String URL = "http://localhost:" + port + "/properties";
        ResponseEntity<Long> responseEntityPost = this.restTemplate
                .postForEntity(URL, propertyDTORequest, Long.class);
        assertEquals(200, responseEntityPost.getStatusCodeValue());

        //Creating objects
        String urlVariables = "?age=5&bedroomsQty=1";

        //Request
        ResponseEntity<String> responseEntityGet = this.restTemplate
                .getForEntity(URL+urlVariables, String.class);

        //Validation
        assertEquals(200, responseEntityGet.getStatusCodeValue());
        assertEquals(propertyDTORequest, getPropertyDTOFromResponse(responseEntityGet, 0));
    }


    private PropertyDTO getPropertyDTOFromResponse(ResponseEntity<String> response, int propertyIndex){
        Gson g = new Gson();
        Type collectionType = new TypeToken<List<PropertyDTO>>(){}.getType();
        List<PropertyDTO> propertyDTOList = g.fromJson(response.getBody(), collectionType);
        return propertyDTOList.get(propertyIndex);
    }
}
