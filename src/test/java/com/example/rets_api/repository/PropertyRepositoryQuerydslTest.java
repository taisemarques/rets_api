package com.example.rets_api.repository;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.service.PropertyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static java.lang.Long.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.example.rets_api.repository", "com.example.rets_api.service"})
public class PropertyRepositoryQuerydslTest {

    @Autowired
    PropertyRepositoryQuerydsl propertyRepositoryQuerydsl;

    @Autowired
    PropertyService propertyService;

    @Test
    public void should_find_no_Property_if_repository_is_empty(){
        List<PropertyEntity> properties = propertyRepositoryQuerydsl.fetchAll(new PropertyFilter());
        assertThat(properties).isEmpty();
    }

    @Test
    public void should_store_an_Property() {
        PropertyDTO propertydto = PropertyDTO.builder()
                .description("Description")
                .price(valueOf(500000))
                .build();
        Long idBook = propertyService.createProperty(propertydto);

        PropertyFilter propertyFilter = new PropertyFilter();
        propertyFilter.setPrice(valueOf(500000));
        propertyFilter.setDescription("Description");
        List<PropertyEntity> properties = propertyRepositoryQuerydsl.fetchAll(propertyFilter);
        assertThat(properties.size() == 1);
    }
}
