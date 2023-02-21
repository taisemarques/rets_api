package com.example.rets_api.repository;

import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.*;
import com.example.rets_api.resource.Enums.*;
import com.example.rets_api.resource.PropertyFilter;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import java.util.List;

import static com.example.rets_api.resource.Constants.*;
import static java.util.Objects.isNull;
import static org.springframework.util.ObjectUtils.isEmpty;

@Repository
public class PropertyRepositoryQuerydsl extends QuerydslRepositorySupport {

    private final QPropertyEntity property = QPropertyEntity.propertyEntity;
    private final QRoomEntity room = QRoomEntity.roomEntity;
    private final QSchoolEntity school = QSchoolEntity.schoolEntity;
    private final QViewDataEntity viewData = QViewDataEntity.viewDataEntity;
    private final QFinancialDataEntity financialData = QFinancialDataEntity.financialDataEntity;
    private final QAnimalPolicyEntity animalPolicy = QAnimalPolicyEntity.animalPolicyEntity;
    private final QLotDataEntity lotData = QLotDataEntity.lotDataEntity;
    private final QCommunityEntity community = QCommunityEntity.communityEntity;
    private final QContactInformationEntity contactInformation = QContactInformationEntity.contactInformationEntity;
    private final QPhoneEntity agentPhone = new QPhoneEntity("agentPhone");
    private final QPhoneEntity listAgentPhone = new QPhoneEntity("listAgentPhone");
    private final QPhoneEntity officePhone = new QPhoneEntity("officePhone");
    private final QPhoneEntity listOfficePhone = new QPhoneEntity("listOfficePhone");
    private final QPhoneEntity salesAgentPhone = new QPhoneEntity("salesAgentPhone");
    private final QPhoneEntity salesOfficePhone = new QPhoneEntity("salesOfficePhone");

    private PropertyFilter filterParams;

    public PropertyRepositoryQuerydsl() {
        super(PropertyEntity.class);
    }

    public List<PropertyEntity> fetchAll(PropertyFilter filterParams) {

        this.filterParams = filterParams;

        // Joining tables
        JPQLQuery<PropertyEntity> query = from(property).distinct()
                .leftJoin(room).on(property.roomList.contains(room))
                .leftJoin(school).on(property.schoolList.contains(school))
                .leftJoin(viewData).on(property.propertyId.eq(viewData.property.propertyId))
                .leftJoin(financialData).on(property.propertyId.eq(financialData.property.propertyId))
                .leftJoin(animalPolicy).on(property.animalPolicy.eq(animalPolicy))
                .leftJoin(lotData).on(property.lotData.eq(lotData))
                .leftJoin(community).on(property.community.eq(community))
                .leftJoin(contactInformation).on(property.contactInformation.contactInformationId.eq(contactInformation.contactInformationId))
                .leftJoin(agentPhone).on(contactInformation.agentPhone.phoneId.eq(agentPhone.phoneId))
                .leftJoin(listAgentPhone).on(contactInformation.listAgentPhone.phoneId.eq(listAgentPhone.phoneId))
                .leftJoin(officePhone).on(contactInformation.officePhone.phoneId.eq(officePhone.phoneId))
                .leftJoin(listOfficePhone).on(contactInformation.listOfficePhone.phoneId.eq(listOfficePhone.phoneId))
                .leftJoin(salesAgentPhone).on(contactInformation.salesAgentPhone.phoneId.eq(salesAgentPhone.phoneId))
                .leftJoin(salesOfficePhone).on(contactInformation.salesOfficePhone.phoneId.eq(salesOfficePhone.phoneId));

        if(filterParams.getPropertyAgeStart() != DEFAULT_INTEGER_VALUE || filterParams.getPropertyAgeEnd() != DEFAULT_INTEGER_VALUE)
            query = configureAgeInTheQuery(query);

        if(filterParams.getPropertyBedroomsQtyStart() != DEFAULT_INTEGER_VALUE || filterParams.getPropertyBedroomsQtyEnd() != DEFAULT_INTEGER_VALUE)
            query = configureBedroomInTheQuery(query);

        if(filterParams.getPropertyBathroomsQtyStart() != DEFAULT_INTEGER_VALUE || filterParams.getPropertyBathroomsQtyEnd() != DEFAULT_INTEGER_VALUE)
            query = configureBathroomInTheQuery(query);

        if (!filterParams.getPropertyHorseFacilitiesDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.horseFacilities.likeIgnoreCase(filterParams.getPropertyHorseFacilitiesDescription()));

        if (!filterParams.getPropertyHorseFacilitiesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.horseFacilitiesIndicator.eq(filterParams.getPropertyHorseFacilitiesIndicator()));

        if (!filterParams.getPropertyHotTubDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.hotTub.likeIgnoreCase(filterParams.getPropertyHotTubDescription()));

        if (!filterParams.getPropertyHotTubIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.hotTubIndicator.eq(filterParams.getPropertyHotTubIndicator()));

        if (!filterParams.getPropertyTennisCourtDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.tennisCourt.likeIgnoreCase(filterParams.getPropertyTennisCourtDescription()));

        if (!filterParams.getPropertyTennisCourtIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.tennisCourtIndicator.eq(filterParams.getPropertyTennisCourtIndicator()));

        if (!filterParams.getPropertyInclusionsDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.inclusions.likeIgnoreCase(filterParams.getPropertyInclusionsDescription()));

        if (!filterParams.getPropertyEnergyInformationDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.energyInformation.likeIgnoreCase(filterParams.getPropertyEnergyInformationDescription()));

        if (!filterParams.getPropertyConstructionMaterialDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.constructionMaterial.likeIgnoreCase(filterParams.getPropertyConstructionMaterialDescription()));

        if (!filterParams.getPropertyDisabilityFeaturesDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.disabilityFeatures.likeIgnoreCase(filterParams.getPropertyDisabilityFeaturesDescription()));

        if (!filterParams.getPropertyDisabilityFeaturesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.disabilityFeaturesIndicator.eq(filterParams.getPropertyDisabilityFeaturesIndicator()));

        if (!filterParams.getPropertySecurityFeaturesDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.securityFeatures.likeIgnoreCase(filterParams.getPropertySecurityFeaturesDescription()));

        if (!filterParams.getPropertySecurityFeaturesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.securityFeaturesIndicator.eq(filterParams.getPropertySecurityFeaturesIndicator()));

        if (filterParams.getPropertyTypeRental() != DEFAULT_BOOLEAN_VALUE)
            query = query.where(property.propertyTypeRental.eq(filterParams.getPropertyTypeRental()));

        if (filterParams.getPropertyTypeCondo() != DEFAULT_BOOLEAN_VALUE)
            query = query.where(property.propertyTypeCondo.eq(filterParams.getPropertyTypeCondo()));

        if (filterParams.getPropertyTypeFarm() != DEFAULT_BOOLEAN_VALUE)
            query = query.where(property.propertyTypeFarm.eq(filterParams.getPropertyTypeFarm()));

        if (filterParams.getPropertyTypeTownHouse() != DEFAULT_BOOLEAN_VALUE)
            query = query.where(property.propertyTypeTownHouse.eq(filterParams.getPropertyTypeTownHouse()));

        if (!isEmpty(filterParams.getPropertyBathSizes()))
            query = configureBathSizesInTheQuery(query);

        if (!filterParams.getPropertyFirePlaceFuelType().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.firePlaceFuelType.likeIgnoreCase(filterParams.getPropertyFirePlaceFuelType()));

        if (!filterParams.getPropertyFirePlaceDetails().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.firePlaceDetails.likeIgnoreCase(filterParams.getPropertyFirePlaceDetails()));

        if (!filterParams.getPropertyFloorsHardwood().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.floorsHardwood.likeIgnoreCase(filterParams.getPropertyFloorsHardwood()));

        if (!filterParams.getPropertyFloorsHardwoodIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.floorsHardwoodIndicator.eq(filterParams.getPropertyFloorsHardwoodIndicator()));

        if (filterParams.getPropertyDisplayFlagListing() != DEFAULT_BOOLEAN_VALUE)
            query = query.where(property.displayFlagListing.eq(filterParams.getPropertyDisplayFlagListing()));

        if (filterParams.getPropertyDisplayFlagAddress() != DEFAULT_BOOLEAN_VALUE)
            query = query.where(property.displayFlagAddress.eq(filterParams.getPropertyDisplayFlagAddress()));

        if (!filterParams.getPropertyLotSizeRange().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.lotSizeRange.likeIgnoreCase(filterParams.getPropertyLotSizeRange()));

        if (!filterParams.getPropertyLotSizeRangeUnits().equals(AreaUnit.DEFAULT_ENUM_VALUE))
            query = query.where(property.lotSizeRangeUnits.eq(filterParams.getPropertyLotSizeRangeUnits()));

        if (!filterParams.getPropertyLotSizeWidthUnits().equals(LengthWidthUnit.DEFAULT_ENUM_VALUE))
            query = query.where(property.lotSizeWidthUnits.eq(filterParams.getPropertyLotSizeWidthUnits()));

        if (!filterParams.getPropertyDiningRoomWidthUnits().equals(LengthWidthUnit.DEFAULT_ENUM_VALUE))
            query = query.where(property.diningRoomWidthUnits.eq(filterParams.getPropertyDiningRoomWidthUnits()));

        if (!filterParams.getPropertyFamilyRoomWidthUnits().equals(LengthWidthUnit.DEFAULT_ENUM_VALUE))
            query = query.where(property.familyRoomWidthUnits.eq(filterParams.getPropertyFamilyRoomWidthUnits()));

        if (!filterParams.getPropertyLivingRoomWidthUnits().equals(LengthWidthUnit.DEFAULT_ENUM_VALUE))
            query = query.where(property.livingRoomWidthUnits.eq(filterParams.getPropertyLivingRoomWidthUnits()));

        if (!filterParams.getPropertyBasementWidthUnits().equals(LengthWidthUnit.DEFAULT_ENUM_VALUE))
            query = query.where(property.basementWidthUnits.eq(filterParams.getPropertyBasementWidthUnits()));

        if (!filterParams.getPropertyLotSizeLengthUnits().equals(LengthWidthUnit.DEFAULT_ENUM_VALUE))
            query = query.where(property.lotSizeLengthUnits.eq(filterParams.getPropertyLotSizeLengthUnits()));

        if (!filterParams.getPropertyDiningRoomLengthUnits().equals(LengthWidthUnit.DEFAULT_ENUM_VALUE))
            query = query.where(property.diningRoomLengthUnits.eq(filterParams.getPropertyDiningRoomLengthUnits()));

        if (!filterParams.getPropertyLivingRoomLengthUnits().equals(LengthWidthUnit.DEFAULT_ENUM_VALUE))
            query = query.where(property.livingRoomLengthUnits.eq(filterParams.getPropertyLivingRoomLengthUnits()));

        if (!filterParams.getPropertyFamilyRoomLengthUnits().equals(LengthWidthUnit.DEFAULT_ENUM_VALUE))
            query = query.where(property.familyRoomLengthUnits.eq(filterParams.getPropertyFamilyRoomLengthUnits()));

        if (!filterParams.getPropertyBasementLengthUnits().equals(LengthWidthUnit.DEFAULT_ENUM_VALUE))
            query = query.where(property.basementLengthUnits.eq(filterParams.getPropertyBasementLengthUnits()));

        if (filterParams.getPropertyParkingTotal() != DEFAULT_NUMBER_VALUE)
            query = query.where(property.parkingTotal.eq(filterParams.getPropertyParkingTotal()));

        if (!filterParams.getPropertyParkingTotalOperator().equals(Operator.DEFAULT_ENUM_VALUE))
            query = query.where(property.parkingTotalOperator.eq(filterParams.getPropertyParkingTotalOperator()));

        if(!isEmpty(filterParams.getSchoolList()))
            query = configureSchoolListInTheQuery(query);

        if (!filterParams.getViewDataCityLightIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.cityLightIndicator.eq(filterParams.getViewDataCityLightIndicator()));

        if (!filterParams.getViewDataMountainIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.mountainIndicator.eq(filterParams.getViewDataMountainIndicator()));

        if (!filterParams.getViewDataRiverIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.riverIndicator.eq(filterParams.getViewDataRiverIndicator()));

        if (!filterParams.getViewDataLakeIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.lakeIndicator.eq(filterParams.getViewDataLakeIndicator()));

        if (!filterParams.getViewDataGolfCourseIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.golfCourseIndicator.eq(filterParams.getViewDataGolfCourseIndicator()));

        if (!filterParams.getViewDataWaterIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.waterIndicator.eq(filterParams.getViewDataWaterIndicator()));

        if (!filterParams.getFinancialDataTradeIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(financialData.tradeIndicator.eq(filterParams.getFinancialDataTradeIndicator()));

        if (!filterParams.getFinancialDataLeaseIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(financialData.leaseIndicator.eq(filterParams.getFinancialDataLeaseIndicator()));

        if(!filterParams.getFinancialDataRentalAmountStart().equals(DEFAULT_LONG_VALUE) || !filterParams.getFinancialDataRentalAmountEnd().equals(DEFAULT_LONG_VALUE))
            query = configureRentAmountInTheQuery(query);

        if (!filterParams.getAnimalPolicyAnimalPermitted().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(animalPolicy.animalsPermitted.eq(filterParams.getAnimalPolicyAnimalPermitted()));

        if (!filterParams.getLotDataGolfCourseLotIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(lotData.golfCourseLotIndicator.eq(filterParams.getLotDataGolfCourseLotIndicator()));

        if (!filterParams.getLotDataCuldeSacIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(lotData.culdeSacIndicator.eq(filterParams.getLotDataCuldeSacIndicator()));

        if (!filterParams.getLotDataCornerLotIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(lotData.cornerLotIndicator.eq(filterParams.getLotDataCornerLotIndicator()));

        if (!filterParams.getCommunityClubHouseIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.clubHouseIndicator.eq(filterParams.getCommunityClubHouseIndicator()));

        if (!filterParams.getCommunityExerciseAreaIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.exerciseAreaIndicator.eq(filterParams.getCommunityExerciseAreaIndicator()));

        if (!filterParams.getCommunityGolfIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.golfIndicator.eq(filterParams.getCommunityGolfIndicator()));

        if (!filterParams.getCommunityTennisIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.tennisIndicator.eq(filterParams.getCommunityTennisIndicator()));

        if (!filterParams.getCommunityRecreationalFacilitiesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.recreationalFacilitiesIndicator.eq(filterParams.getCommunityRecreationalFacilitiesIndicator()));

        if (!filterParams.getCommunitySecurityFeaturesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.securityFeaturesIndicator.eq(filterParams.getCommunitySecurityFeaturesIndicator()));

        if (!filterParams.getCommunitySeniorCommunityIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.seniorCommunityIndicator.eq(filterParams.getCommunitySeniorCommunityIndicator()));

        if (!filterParams.getCommunityHotTubIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.hotTubIndicator.eq(filterParams.getCommunityHotTubIndicator()));

        if (!filterParams.getCommunityPoolIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.poolIndicator.eq(filterParams.getCommunityPoolIndicator()));

        if (!filterParams.getCommunityBoatFacilitiesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.boatFacilitiesIndicator.eq(filterParams.getCommunityBoatFacilitiesIndicator()));

        if (!filterParams.getCommunityHorseFacilitiesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.horseFacilitiesIndicator.eq(filterParams.getCommunityHorseFacilitiesIndicator()));

        if (!filterParams.getCommunityParkIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.communityParkIndicator.eq(filterParams.getCommunityParkIndicator()));

        if(!isEmpty(filterParams.getContactInformationPhoneNumbers()))
            query = configurePhoneNumberInTheQuery(query);

        return query.fetch();
    }

    private JPQLQuery<PropertyEntity> configureAgeInTheQuery(JPQLQuery<PropertyEntity> query) {
        return configureNumberPathInTheQuery(query, property.age, filterParams.getPropertyAgeStart(), filterParams.getPropertyAgeEnd(),
                    filterParams.getPropertyAgeStartOperator(), filterParams.getPropertyAgeEndOperator());
    }

    private JPQLQuery<PropertyEntity> configureBedroomInTheQuery(JPQLQuery<PropertyEntity> query) {
        return configureNumberPathInTheQuery(query, property.bedroomsQty, filterParams.getPropertyBedroomsQtyStart(), filterParams.getPropertyBedroomsQtyEnd(),
                filterParams.getPropertyBedroomsQtyStartOperator(), filterParams.getPropertyBedroomsQtyEndOperator());
    }

    private JPQLQuery<PropertyEntity> configureBathroomInTheQuery(JPQLQuery<PropertyEntity> query) {
        return configureNumberPathInTheQuery(query, property.bathroomsQty, filterParams.getPropertyBathroomsQtyStart(), filterParams.getPropertyBathroomsQtyEnd(),
                filterParams.getPropertyBathroomsQtyStartOperator(), filterParams.getPropertyBathroomsQtyEndOperator());
    }

    private JPQLQuery<PropertyEntity> configureRentAmountInTheQuery(JPQLQuery<PropertyEntity> query) {
        return configureNumberPathInTheQuery(query, financialData.rentalAmount, filterParams.getFinancialDataRentalAmountStart(), filterParams.getFinancialDataRentalAmountEnd(),
                filterParams.getFinancialDataRentalAmountStartOperator(), filterParams.getFinancialDataRentalAmountEndOperator());
    }

    private JPQLQuery<PropertyEntity> configurePhoneNumberInTheQuery(JPQLQuery<PropertyEntity> query) {
        List<String> phoneNumbers = filterParams.getContactInformationPhoneNumbers();
        BooleanBuilder builder = new BooleanBuilder()
                .or(agentPhone.primaryPhone.in(phoneNumbers))
                .or(agentPhone.alternatePhone.in(phoneNumbers))
                .or(listAgentPhone.primaryPhone.in(phoneNumbers))
                .or(listAgentPhone.alternatePhone.in(phoneNumbers))
                .or(salesAgentPhone.primaryPhone.in(phoneNumbers))
                .or(salesAgentPhone.alternatePhone.in(phoneNumbers))
                .or(officePhone.primaryPhone.in(phoneNumbers))
                .or(officePhone.alternatePhone.in(phoneNumbers))
                .or(listOfficePhone.primaryPhone.in(phoneNumbers))
                .or(listOfficePhone.alternatePhone.in(phoneNumbers))
                .or(salesOfficePhone.primaryPhone.in(phoneNumbers))
                .or(salesOfficePhone.alternatePhone.in(phoneNumbers));
        return query.where(builder);
    }

    private JPQLQuery<PropertyEntity> configureBathSizesInTheQuery(JPQLQuery<PropertyEntity> query) {
        BooleanBuilder builder = new BooleanBuilder();
        for(BathSize bathSize: filterParams.getPropertyBathSizes()) {
            if(!bathSize.equals(BathSize.DEFAULT_ENUM_VALUE)) {
                if (bathSize.equals(BathSize.FULL)) {
                    builder = builder.or(room.roomType.eq(RoomType.MASTER_BEDROOM).orAllOf(room.roomType.eq(RoomType.MAIN_FLOOR_BATHROOM), room.bathSize.eq(bathSize)));
                } else {
                    builder = builder.or(room.bathSize.eq(bathSize).and(room.roomType.eq(RoomType.MAIN_FLOOR_BATHROOM)));
                }
            }
        }
        return query.where(builder);
    }

    private JPQLQuery<PropertyEntity> configureSchoolListInTheQuery(JPQLQuery<PropertyEntity> query) {
        BooleanBuilder builder = new BooleanBuilder();
        for(SchoolDTO schoolDTO: filterParams.getSchoolList()) {
            if(!isNull(schoolDTO)){
                if(!schoolDTO.getPrimary().equals(DEFAULT_STRING_VALUE) && !schoolDTO.getJrHigh().equals(DEFAULT_STRING_VALUE)){
                    builder = builder.or(school.primarySchool.eq(schoolDTO.getPrimary()).and(school.jrHigh.eq(schoolDTO.getJrHigh())));
                } else if(schoolDTO.getPrimary().equals(DEFAULT_STRING_VALUE) && !schoolDTO.getJrHigh().equals(DEFAULT_STRING_VALUE)){
                    builder = builder.or(school.jrHigh.eq(schoolDTO.getJrHigh()));
                } else if(!schoolDTO.getPrimary().equals(DEFAULT_STRING_VALUE) && schoolDTO.getJrHigh().equals(DEFAULT_STRING_VALUE)){
                    builder = builder.or(school.primarySchool.eq(schoolDTO.getPrimary()));
                }
            }
        }
        return query.where(builder);
    }

    private <T extends Number & Comparable<?>>JPQLQuery<PropertyEntity> configureNumberPathInTheQuery(
            JPQLQuery<PropertyEntity> query, NumberPath<T> numberPath, T start, T end, Operator operatorStart, Operator operatorEnd) {
        if (start.intValue() != DEFAULT_INTEGER_VALUE && end.intValue() != DEFAULT_INTEGER_VALUE) {
            query.where(numberPath.between(start, end));
        } else if (start.intValue() != DEFAULT_INTEGER_VALUE){
            configureNumberOperator(query, numberPath, start, operatorStart);
        } else if (end.intValue() != DEFAULT_INTEGER_VALUE){
            configureNumberOperator(query, numberPath, end, operatorEnd);
        }
        return query;
    }

    private <T extends Number & Comparable<?>>void configureNumberOperator(
            JPQLQuery<PropertyEntity> query, NumberPath<T> numberPath, T value, Operator operator){
        if(operator.equals(Operator.GREATER_THEN)) {
            query.where(numberPath.goe(value));
        } else if(operator.equals(Operator.LESS_THEN)) {
            query.where(numberPath.loe(value));
        } else {
            query.where(numberPath.eq(value));
        }
    }
}