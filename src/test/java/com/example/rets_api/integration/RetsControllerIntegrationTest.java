package com.example.rets_api.integration;

import com.example.rets_api.RetsApiApplication;
import com.example.rets_api.converter.PropertyConverter;
import com.example.rets_api.converter.ViewDataConverter;
import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.PropertyPatchDTO;
import com.example.rets_api.dto.ViewDataDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.entity.ViewDataEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import java.lang.reflect.Type;
import java.util.List;

import static com.example.rets_api.utils.CompareEntitiesUtilsTest.comparePropertyPatchDTOBasicFields;
import static com.example.rets_api.utils.CompareEntitiesUtilsTest.compareViewData;
import static com.example.rets_api.utils.DtoUtilsTest.*;
import static com.example.rets_api.utils.FilterUtilsTest.createURLVariablesOperatorAgeBedroomBathroom;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = RetsApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RetsControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        this.restTemplate.getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }

    @Test
    public void creatingProperty() {
        //Creating objects
        PropertyDTO propertyDTORequest = createPropertyDTOWithAllFields();
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
        PropertyDTO propertyDTORequest = createPropertyDTOWithAllFields();
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
        PropertyDTO propertyDTORequest = createPropertyDTOWithAllFields();
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
    public void deletePropertyById() {
        //Preparing scenario: Adding a property
        PropertyDTO propertyDTORequest = createPropertyDTOWithAllFields();
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

    @Test
    public void patchProperty() {
        //Creating objects
        PropertyDTO propertyDTORequest = createPropertyDTOWithBasicFields();
        PropertyPatchDTO propertyPatchDTORequest = createPropertyPatchDTO();
        String URL = "http://localhost:" + port + "/properties";

        //Request
        ResponseEntity<Long> responseEntity = this.restTemplate
                .postForEntity(URL, propertyDTORequest, Long.class);

        //Creating objects
        String URLWithID = URL
                .concat("/")
                .concat(String.valueOf(responseEntity.getBody()));

        //Request
        ResponseEntity<PropertyDTO> responsePatchEntity = this.restTemplate
                .exchange(URLWithID,HttpMethod.PATCH, new HttpEntity<>(propertyPatchDTORequest), PropertyDTO.class);

        PropertyEntity response = PropertyConverter.propertyDTOToPropertyEntity.convert(responsePatchEntity.getBody());

        //Validation
        assertEquals(200, responsePatchEntity.getStatusCodeValue());
        assertNotNull(responsePatchEntity.getBody());
        comparePropertyPatchDTOBasicFields(PropertyConverter.propertyEntityToPropertyPatchDTO.convert(response), propertyPatchDTORequest);
    }

    @Test
    public void patchPropertyNotExist() {
        //Creating objects
        PropertyPatchDTO propertyPatchDTORequest = createPropertyPatchDTO();

        String URL = "http://localhost:" + port + "/properties";

        //Creating objects
        String URLWithID = URL
                .concat("/")
                .concat(String.valueOf(123456));

        ResponseEntity<PropertyDTO> responsePatchEntity = this.restTemplate
                .exchange(URLWithID,HttpMethod.PATCH, new HttpEntity<>(propertyPatchDTORequest), PropertyDTO.class);

        //Validation
        assertEquals(404, responsePatchEntity.getStatusCodeValue());
    }

    @Test
    public void patchViewData_saveNewViewData() {
        //Creating objects
        PropertyDTO propertyDTORequest = createPropertyDTOWithBasicFields();
        ViewDataDTO viewDataDTORequest = createViewDataDTO();
        String URL = "http://localhost:" + port + "/properties";

        //Request
        ResponseEntity<Long> responseEntity = this.restTemplate
                .postForEntity(URL, propertyDTORequest, Long.class);

        //Creating objects
        String URLviewData = URL
                .concat("/")
                .concat(String.valueOf(responseEntity.getBody()))
                .concat("/viewData");

        //Request
        ResponseEntity<ViewDataDTO> responsePatchEntity = this.restTemplate
                .exchange(URLviewData, HttpMethod.PATCH, new HttpEntity<>(viewDataDTORequest), ViewDataDTO.class);

        ViewDataEntity response = ViewDataConverter.viewDataDTOToViewDataEntity.convert(responsePatchEntity.getBody());

        //Validation
        assertEquals(200, responsePatchEntity.getStatusCodeValue());
        assertNotNull(responsePatchEntity.getBody());
        compareViewData(response, ViewDataConverter.viewDataDTOToViewDataEntity.convert(viewDataDTORequest));
    }

    @Test
    public void patchViewData_updateViewData() {
        //Creating objects
        PropertyDTO propertyDTORequest = createPropertyDTOWithAllFields();
        ViewDataDTO viewDataDTORequest = createViewDataDTO();
        String URL = "http://localhost:" + port + "/properties";

        //Request
        ResponseEntity<Long> responseEntity = this.restTemplate
                .postForEntity(URL, propertyDTORequest, Long.class);

        //Creating objects
        String URLviewData = URL
                .concat("/")
                .concat(String.valueOf(responseEntity.getBody()))
                .concat("/viewData");

        //Request
        ResponseEntity<ViewDataDTO> responsePatchEntity = this.restTemplate
                .exchange(URLviewData, HttpMethod.PATCH, new HttpEntity<>(viewDataDTORequest), ViewDataDTO.class);

        ViewDataEntity response = ViewDataConverter.viewDataDTOToViewDataEntity.convert(responsePatchEntity.getBody());

        //Validation
        assertEquals(200, responsePatchEntity.getStatusCodeValue());
        assertNotNull(responsePatchEntity.getBody());
        compareViewData(response, ViewDataConverter.viewDataDTOToViewDataEntity.convert(viewDataDTORequest));
    }

    @Test
    public void patchViewDataNotExist() {
        //Creating objects
        ViewDataDTO propertyPatchDTORequest = createViewDataDTO();

        String URL = "http://localhost:" + port + "/properties";

        //Creating objects
        String URLWithID = URL
                .concat("/")
                .concat(String.valueOf(123456))
                .concat("/viewData");

        ResponseEntity<ViewDataDTO> responsePatchEntity = this.restTemplate
                .exchange(URLWithID,HttpMethod.PATCH, new HttpEntity<>(propertyPatchDTORequest), ViewDataDTO.class);

        //Validation
        assertEquals(404, responsePatchEntity.getStatusCodeValue());
    }


    private PropertyDTO getPropertyDTOFromResponse(ResponseEntity<String> response, int propertyIndex){
        Gson g = new Gson();
        Type collectionType = new TypeToken<List<PropertyDTO>>(){}.getType();
        List<PropertyDTO> propertyDTOList = g.fromJson(response.getBody(), collectionType);
        return propertyDTOList.get(propertyIndex);
    }

}
