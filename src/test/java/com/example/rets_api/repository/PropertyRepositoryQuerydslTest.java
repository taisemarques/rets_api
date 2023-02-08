package com.example.rets_api.repository;

import com.example.rets_api.dto.FinancialDataDTO;
import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.RoomDTO;
import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.Enums.*;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.service.PropertyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
        FinancialDataDTO financialDataDTO = FinancialDataDTO.builder()
                .leaseOption("firstOption")
                .leaseIndicator(Indicator.YES)
                .rentalAmount(456L)
                .tradeOption("trading")
                .rentalAmountType(NumberType.FLOAT)
                .rentalAmountCurrencyCode("CAD")
                .rentalAmountPeriod(RentalPeriod.MONTH)
                .rentalAmountUnit(AreaUnit.SQ_FEET)
                .tradeIndicator(Indicator.NO)
                .build();

        List<SchoolDTO> schools = new ArrayList<>();
        SchoolDTO school = SchoolDTO.builder()
                .jrHigh("jrHigh")
                .primary("primary school")
                .build();
        schools.add(school);

        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO firstRoom = RoomDTO.builder()
                .type(RoomType.MASTER_BEDROOM)
                .indicator(Indicator.YES)
                .areaType(AreaType.INTEGER)
                .areaUnit(AreaUnit.SQ_FEET)
                .area(9)
                .dimensions("dimenstions")
                .bathSize(BathSize.HALF)
                .length(3)
                .lengthUnit(LengthWidthUnit.FEET)
                .width(3)
                .widthUnit(LengthWidthUnit.FEET)
                .build();

        RoomDTO secondRoom = RoomDTO.builder()
                .type(RoomType.LIVING_ROOM)
                .indicator(Indicator.YES)
                .areaType(AreaType.INTEGER)
                .areaUnit(AreaUnit.SQ_FEET)
                .area(15)
                .dimensions("dimenstions")
                .bathSize(BathSize.FULL)
                .length(5)
                .lengthUnit(LengthWidthUnit.FEET)
                .width(3)
                .widthUnit(LengthWidthUnit.FEET)
                .build();


        rooms.add(firstRoom);
        rooms.add(secondRoom);

        PropertyDTO propertydto = PropertyDTO.builder()
                .age(5)
                .horseFacilities("horsefacilities")
                .horseFacilitiesIndicator(Indicator.YES)
                .hotTub("hotTub")
                .hotTubIndicator(Indicator.NO)
                .tennisCourt("tennisCourt")
                .tennisCourtIndicator(Indicator.UNKNOWN)
                .inclusions("inclusions")
                .energyInformation("energyInformation")
                .constructionMaterial("constructionMaterial")
                .disabilityFeatures("disabilityFeatures")
                .disabilityFeaturesIndicator(Indicator.NO)
                .securityFeatures("secure")
                .securityFeaturesIndicator(Indicator.YES)
                .propertyTypeRental(true)
                .propertyTypeFarm(false)
                .propertyTypeCondo(true)
                .propertyTypeTownHouse(false)
                .financialData(financialDataDTO)
                .schoolDTOList(schools)
                .roomDTOList(rooms)
                .build();

        Long idBook = propertyService.createProperty(propertydto);
        List<SchoolDTO> schoolsFilter = new ArrayList<>();
        SchoolDTO schoolFilter = SchoolDTO.builder().jrHigh("jrHigh").build();
        schoolsFilter.add(schoolFilter);

        PropertyFilter propertyFilter = new PropertyFilter();
        propertyFilter.setAge(5);
        propertyFilter.setHorseFacilities("horsefacilities");
        propertyFilter.setBathroomsQty(0);
        propertyFilter.setBedroomsQty(2);
        propertyFilter.setDisabilityFeaturesIndicator(Indicator.NO);
        propertyFilter.setDisabilityFeatures("secure");
        propertydto.setPropertyTypeRental(true);
        propertydto.setSchoolDTOList(schoolsFilter);
        List<PropertyEntity> properties = propertyRepositoryQuerydsl.fetchAll(propertyFilter);
        assertThat(properties.size() == 1);
    }
}
