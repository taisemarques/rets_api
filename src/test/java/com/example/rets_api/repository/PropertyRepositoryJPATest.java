package com.example.rets_api.repository;

import com.example.rets_api.entity.PropertyEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.lang.Long.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PropertyRepositoryJPATest {

    @Autowired
    PropertyRepositoryJPA propertyRepository;

    @Test
    public void should_find_no_Property_if_repository_is_empty(){
        List<PropertyEntity> authors = propertyRepository.findAll();
        assertThat(authors).isEmpty();
    }

    @Test
    public void should_store_a_Property() {
        PropertyEntity propertyToSave = new PropertyEntity();
        propertyToSave.setDescription("Description");
        propertyToSave.setPrice(valueOf(460000));
        PropertyEntity propertySaved = propertyRepository.save(propertyToSave);
        assertThat(propertySaved.getPropertyId()).isNotNull();
        assertThat(propertySaved).hasFieldOrPropertyWithValue("description", propertyToSave.getDescription());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("price", propertyToSave.getPrice());
    }
}
