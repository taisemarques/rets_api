package com.example.rets_api.repository;

import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.utils.EntityUtilsTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.example.rets_api.repository.PropertyRepositoryJPATest.checkAllBasicFieldsFromProperty;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BasicPropertyRepositoryJPATest{
    @Autowired
    PropertyRepositoryJPA propertyRepository;

    @Test
    public void should_find_no_Property_if_repository_is_empty(){
        //Searching
        List<PropertyEntity> properties = propertyRepository.findAll();

        //Validating
        assertTrue(properties.isEmpty());
    }

    @Test
    public void should_store_a_Property_With_Basic_Fields() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

    }

}
