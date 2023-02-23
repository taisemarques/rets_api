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
    private final QListingPriceEntity listingPrice = QListingPriceEntity.listingPriceEntity;

    private PropertyFilter filterParams;
    JPQLQuery<PropertyEntity> query;

    public PropertyRepositoryQuerydsl() {
        super(PropertyEntity.class);
    }

    public List<PropertyEntity> fetchAll(PropertyFilter filterParams) {
        this.filterParams = filterParams;
        addJoinTablesToQuery();
        addOperatorFiltersToQuery();
        addPropertyIndicatorsFiltersToQuery();
        addPropertyDescriptionFiltersToQuery();
        addPropertyBooleanFiltersToQuery();
        addPropertyUnitsFiltersToQuery();
        addViewFiltersToQuery();
        addFinancialDataFiltersToQuery();
        addAnimalPolicyFiltersToQuery();
        addLotDataFiltersToQuery();
        addCommunityFiltersToQuery();
        addBathSizeFilterToQuery();
        addSchoolFilterToQuery();
        addContactInfoFilterToQuery();
        addPriceListingFilterToQuery();
        return query.fetch();
    }

    private void addJoinTablesToQuery() {
        query = from(property).distinct()
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
                .leftJoin(salesOfficePhone).on(contactInformation.salesOfficePhone.phoneId.eq(salesOfficePhone.phoneId))
                .leftJoin(listingPrice).on(property.propertyId.eq(listingPrice.property.propertyId));
    }

    private void addOperatorFiltersToQuery() {
        if(nonDefaultValue(filterParams.getPropertyAgeStart()) || nonDefaultValue(filterParams.getPropertyAgeEnd()))
            addWhereWithRangeValues(property.age, filterParams.getPropertyAgeStart(), filterParams.getPropertyAgeEnd(),
                    filterParams.getPropertyAgeStartOperator(), filterParams.getPropertyAgeEndOperator());

        if(nonDefaultValue(filterParams.getPropertyBedroomsQtyStart()) || nonDefaultValue(filterParams.getPropertyBedroomsQtyEnd()))
            addWhereWithRangeValues(property.bedroomsQty, filterParams.getPropertyBedroomsQtyStart(), filterParams.getPropertyBedroomsQtyEnd(),
                    filterParams.getPropertyBedroomsQtyStartOperator(), filterParams.getPropertyBedroomsQtyEndOperator());

        if(nonDefaultValue(filterParams.getPropertyBathroomsQtyStart()) || nonDefaultValue(filterParams.getPropertyBathroomsQtyEnd()))
            addWhereWithRangeValues(property.bathroomsQty, filterParams.getPropertyBathroomsQtyStart(), filterParams.getPropertyBathroomsQtyEnd(),
                    filterParams.getPropertyBathroomsQtyStartOperator(), filterParams.getPropertyBathroomsQtyEndOperator());

        if(nonDefaultValue(filterParams.getFinancialDataRentalAmountStart()) || nonDefaultValue(filterParams.getFinancialDataRentalAmountEnd()))
            addWhereWithRangeValues(financialData.rentalAmount, filterParams.getFinancialDataRentalAmountStart(), filterParams.getFinancialDataRentalAmountEnd(),
                    filterParams.getFinancialDataRentalAmountStartOperator(), filterParams.getFinancialDataRentalAmountEndOperator());

        if (nonDefaultValue(filterParams.getPropertyParkingTotalStart()) || nonDefaultValue(filterParams.getPropertyParkingTotalEnd()))
            addWhereWithRangeValues(property.parkingTotal, filterParams.getPropertyParkingTotalStart(), filterParams.getPropertyParkingTotalEnd(),
                    filterParams.getPropertyParkingTotalStartOperator(), filterParams.getPropertyParkingTotalEndOperator());
    }

    private void addPropertyIndicatorsFiltersToQuery() {
        if (nonDefaultValue(filterParams.getPropertyHorseFacilitiesIndicator()))
            query = query.where(property.horseFacilitiesIndicator.eq(filterParams.getPropertyHorseFacilitiesIndicator()));

        if (nonDefaultValue(filterParams.getPropertyHotTubIndicator()))
            query = query.where(property.hotTubIndicator.eq(filterParams.getPropertyHotTubIndicator()));

        if (nonDefaultValue(filterParams.getPropertyTennisCourtIndicator()))
            query = query.where(property.tennisCourtIndicator.eq(filterParams.getPropertyTennisCourtIndicator()));

        if (nonDefaultValue(filterParams.getPropertyDisabilityFeaturesIndicator()))
            query = query.where(property.disabilityFeaturesIndicator.eq(filterParams.getPropertyDisabilityFeaturesIndicator()));

        if (nonDefaultValue(filterParams.getPropertySecurityFeaturesIndicator()))
            query = query.where(property.securityFeaturesIndicator.eq(filterParams.getPropertySecurityFeaturesIndicator()));

        if (nonDefaultValue(filterParams.getPropertyFloorsHardwoodIndicator()))
            query = query.where(property.floorsHardwoodIndicator.eq(filterParams.getPropertyFloorsHardwoodIndicator()));
    }

    private void addPropertyDescriptionFiltersToQuery() {
        if (nonDefaultValue(filterParams.getPropertyHorseFacilitiesDescription()))
            query = query.where(property.horseFacilities.likeIgnoreCase(filterParams.getPropertyHorseFacilitiesDescription()));

        if (nonDefaultValue(filterParams.getPropertyHotTubDescription()))
            query = query.where(property.hotTub.likeIgnoreCase(filterParams.getPropertyHotTubDescription()));

        if (nonDefaultValue(filterParams.getPropertyTennisCourtDescription()))
            query = query.where(property.tennisCourt.likeIgnoreCase(filterParams.getPropertyTennisCourtDescription()));

        if (nonDefaultValue(filterParams.getPropertyInclusionsDescription()))
            query = query.where(property.inclusions.likeIgnoreCase(filterParams.getPropertyInclusionsDescription()));

        if (nonDefaultValue(filterParams.getPropertyEnergyInformationDescription()))
            query = query.where(property.energyInformation.likeIgnoreCase(filterParams.getPropertyEnergyInformationDescription()));

        if (nonDefaultValue(filterParams.getPropertyConstructionMaterialDescription()))
            query = query.where(property.constructionMaterial.likeIgnoreCase(filterParams.getPropertyConstructionMaterialDescription()));

        if (nonDefaultValue(filterParams.getPropertyDisabilityFeaturesDescription()))
            query = query.where(property.disabilityFeatures.likeIgnoreCase(filterParams.getPropertyDisabilityFeaturesDescription()));

        if (nonDefaultValue(filterParams.getPropertySecurityFeaturesDescription()))
            query = query.where(property.securityFeatures.likeIgnoreCase(filterParams.getPropertySecurityFeaturesDescription()));

        if (nonDefaultValue(filterParams.getPropertyFirePlaceFuelType()))
            query = query.where(property.firePlaceFuelType.likeIgnoreCase(filterParams.getPropertyFirePlaceFuelType()));

        if (nonDefaultValue(filterParams.getPropertyFirePlaceDetails()))
            query = query.where(property.firePlaceDetails.likeIgnoreCase(filterParams.getPropertyFirePlaceDetails()));

        if (nonDefaultValue(filterParams.getPropertyFloorsHardwood()))
            query = query.where(property.floorsHardwood.likeIgnoreCase(filterParams.getPropertyFloorsHardwood()));

        if (nonDefaultValue(filterParams.getPropertyLotSizeRange()))
            query = query.where(property.lotSizeRange.likeIgnoreCase(filterParams.getPropertyLotSizeRange()));
    }

    private void addPropertyBooleanFiltersToQuery() {
        if (nonDefaultValue(filterParams.getPropertyTypeRental()))
            query = query.where(property.propertyTypeRental.eq(filterParams.getPropertyTypeRental()));

        if (nonDefaultValue(filterParams.getPropertyTypeCondo()))
            query = query.where(property.propertyTypeCondo.eq(filterParams.getPropertyTypeCondo()));

        if (nonDefaultValue(filterParams.getPropertyTypeFarm()))
            query = query.where(property.propertyTypeFarm.eq(filterParams.getPropertyTypeFarm()));

        if (nonDefaultValue(filterParams.getPropertyTypeTownHouse()))
            query = query.where(property.propertyTypeTownHouse.eq(filterParams.getPropertyTypeTownHouse()));

        if (nonDefaultValue(filterParams.getPropertyDisplayFlagListing()))
            query = query.where(property.displayFlagListing.eq(filterParams.getPropertyDisplayFlagListing()));

        if (nonDefaultValue(filterParams.getPropertyDisplayFlagAddress()))
            query = query.where(property.displayFlagAddress.eq(filterParams.getPropertyDisplayFlagAddress()));
    }

    private void addPropertyUnitsFiltersToQuery() {
        if (nonDefaultValue(filterParams.getPropertyLotSizeRangeUnits()))
            query = query.where(property.lotSizeRangeUnits.eq(filterParams.getPropertyLotSizeRangeUnits()));

        if (nonDefaultValue(filterParams.getPropertyLotSizeWidthUnits()))
            query = query.where(property.lotSizeWidthUnits.eq(filterParams.getPropertyLotSizeWidthUnits()));

        if (nonDefaultValue(filterParams.getPropertyDiningRoomWidthUnits()))
            query = query.where(property.diningRoomWidthUnits.eq(filterParams.getPropertyDiningRoomWidthUnits()));

        if (nonDefaultValue(filterParams.getPropertyFamilyRoomWidthUnits()))
            query = query.where(property.familyRoomWidthUnits.eq(filterParams.getPropertyFamilyRoomWidthUnits()));

        if (nonDefaultValue(filterParams.getPropertyLivingRoomWidthUnits()))
            query = query.where(property.livingRoomWidthUnits.eq(filterParams.getPropertyLivingRoomWidthUnits()));

        if (nonDefaultValue(filterParams.getPropertyBasementWidthUnits()))
            query = query.where(property.basementWidthUnits.eq(filterParams.getPropertyBasementWidthUnits()));

        if (nonDefaultValue(filterParams.getPropertyLotSizeLengthUnits()))
            query = query.where(property.lotSizeLengthUnits.eq(filterParams.getPropertyLotSizeLengthUnits()));

        if (nonDefaultValue(filterParams.getPropertyDiningRoomLengthUnits()))
            query = query.where(property.diningRoomLengthUnits.eq(filterParams.getPropertyDiningRoomLengthUnits()));

        if (nonDefaultValue(filterParams.getPropertyLivingRoomLengthUnits()))
            query = query.where(property.livingRoomLengthUnits.eq(filterParams.getPropertyLivingRoomLengthUnits()));

        if (nonDefaultValue(filterParams.getPropertyFamilyRoomLengthUnits()))
            query = query.where(property.familyRoomLengthUnits.eq(filterParams.getPropertyFamilyRoomLengthUnits()));

        if (nonDefaultValue(filterParams.getPropertyBasementLengthUnits()))
            query = query.where(property.basementLengthUnits.eq(filterParams.getPropertyBasementLengthUnits()));
    }

    private void addViewFiltersToQuery() {
        if (nonDefaultValue(filterParams.getViewDataCityLightIndicator()))
            query = query.where(viewData.cityLightIndicator.eq(filterParams.getViewDataCityLightIndicator()));

        if (nonDefaultValue(filterParams.getViewDataMountainIndicator()))
            query = query.where(viewData.mountainIndicator.eq(filterParams.getViewDataMountainIndicator()));

        if (nonDefaultValue(filterParams.getViewDataRiverIndicator()))
            query = query.where(viewData.riverIndicator.eq(filterParams.getViewDataRiverIndicator()));

        if (nonDefaultValue(filterParams.getViewDataLakeIndicator()))
            query = query.where(viewData.lakeIndicator.eq(filterParams.getViewDataLakeIndicator()));

        if (nonDefaultValue(filterParams.getViewDataGolfCourseIndicator()))
            query = query.where(viewData.golfCourseIndicator.eq(filterParams.getViewDataGolfCourseIndicator()));

        if (nonDefaultValue(filterParams.getViewDataWaterIndicator()))
            query = query.where(viewData.waterIndicator.eq(filterParams.getViewDataWaterIndicator()));
    }

    private void addFinancialDataFiltersToQuery() {
        if (nonDefaultValue(filterParams.getFinancialDataTradeIndicator()))
            query = query.where(financialData.tradeIndicator.eq(filterParams.getFinancialDataTradeIndicator()));

        if (nonDefaultValue(filterParams.getFinancialDataLeaseIndicator()))
            query = query.where(financialData.leaseIndicator.eq(filterParams.getFinancialDataLeaseIndicator()));
    }

    private void addAnimalPolicyFiltersToQuery() {
        if (nonDefaultValue(filterParams.getAnimalPolicyAnimalPermitted()))
            query = query.where(animalPolicy.animalsPermitted.eq(filterParams.getAnimalPolicyAnimalPermitted()));
    }

    private void addLotDataFiltersToQuery() {
        if (nonDefaultValue(filterParams.getLotDataGolfCourseLotIndicator()))
            query = query.where(lotData.golfCourseLotIndicator.eq(filterParams.getLotDataGolfCourseLotIndicator()));

        if (nonDefaultValue(filterParams.getLotDataCuldeSacIndicator()))
            query = query.where(lotData.culdeSacIndicator.eq(filterParams.getLotDataCuldeSacIndicator()));

        if (nonDefaultValue(filterParams.getLotDataCornerLotIndicator()))
            query = query.where(lotData.cornerLotIndicator.eq(filterParams.getLotDataCornerLotIndicator()));
    }

    private void addCommunityFiltersToQuery() {
        if (nonDefaultValue(filterParams.getCommunityClubHouseIndicator()))
            query = query.where(community.clubHouseIndicator.eq(filterParams.getCommunityClubHouseIndicator()));

        if (nonDefaultValue(filterParams.getCommunityExerciseAreaIndicator()))
            query = query.where(community.exerciseAreaIndicator.eq(filterParams.getCommunityExerciseAreaIndicator()));

        if (nonDefaultValue(filterParams.getCommunityGolfIndicator()))
            query = query.where(community.golfIndicator.eq(filterParams.getCommunityGolfIndicator()));

        if (nonDefaultValue(filterParams.getCommunityTennisIndicator()))
            query = query.where(community.tennisIndicator.eq(filterParams.getCommunityTennisIndicator()));

        if (nonDefaultValue(filterParams.getCommunityRecreationalFacilitiesIndicator()))
            query = query.where(community.recreationalFacilitiesIndicator.eq(filterParams.getCommunityRecreationalFacilitiesIndicator()));

        if (nonDefaultValue(filterParams.getCommunitySecurityFeaturesIndicator()))
            query = query.where(community.securityFeaturesIndicator.eq(filterParams.getCommunitySecurityFeaturesIndicator()));

        if (nonDefaultValue(filterParams.getCommunitySeniorCommunityIndicator()))
            query = query.where(community.seniorCommunityIndicator.eq(filterParams.getCommunitySeniorCommunityIndicator()));

        if (nonDefaultValue(filterParams.getCommunityHotTubIndicator()))
            query = query.where(community.hotTubIndicator.eq(filterParams.getCommunityHotTubIndicator()));

        if (nonDefaultValue(filterParams.getCommunityPoolIndicator()))
            query = query.where(community.poolIndicator.eq(filterParams.getCommunityPoolIndicator()));

        if (nonDefaultValue(filterParams.getCommunityBoatFacilitiesIndicator()))
            query = query.where(community.boatFacilitiesIndicator.eq(filterParams.getCommunityBoatFacilitiesIndicator()));

        if (nonDefaultValue(filterParams.getCommunityHorseFacilitiesIndicator()))
            query = query.where(community.horseFacilitiesIndicator.eq(filterParams.getCommunityHorseFacilitiesIndicator()));

        if (nonDefaultValue(filterParams.getCommunityParkIndicator()))
            query = query.where(community.communityParkIndicator.eq(filterParams.getCommunityParkIndicator()));
    }

    private void addBathSizeFilterToQuery() {
        if (!isEmpty(filterParams.getPropertyBathSizes())){
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
            query = query.where(builder);
        }
    }

    private void addSchoolFilterToQuery() {
        if(!isEmpty(filterParams.getSchoolList())){
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
            query = query.where(builder);
        }
    }

    private void addContactInfoFilterToQuery() {
        if(!isEmpty(filterParams.getContactInformationPhoneNumbers())) {
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
            query = query.where(builder);
        }
    }

    private void addPriceListingFilterToQuery() {
        if(nonDefaultValue(filterParams.getListingPriceLowAmount()))
            query = query.where(listingPrice.lowAmount.goe(filterParams.getListingPriceLowAmount()));

        if(nonDefaultValue(filterParams.getListingPriceHighAmount()))
            query = query.where(listingPrice.highAmount.loe(filterParams.getListingPriceHighAmount()));

        if(nonDefaultValue(filterParams.getListingPriceLowAmountCurrencyCode()))
            query = query.where(listingPrice.lowAmountCurrencyCode.equalsIgnoreCase(filterParams.getListingPriceLowAmountCurrencyCode()));

        if(nonDefaultValue(filterParams.getListingPriceHighAmountCurrencyCode()))
            query = query.where(listingPrice.highAmountCurrencyCode.equalsIgnoreCase(filterParams.getListingPriceHighAmountCurrencyCode()));

        if(nonDefaultValue(filterParams.getListingPriceUnits()))
            query = query.where(listingPrice.units.eq(filterParams.getListingPriceUnits()));

    }

    private <T extends Number & Comparable<?>>void addWhereWithRangeValues(NumberPath<T> numberPath, T start, T end,
                                                                           Operator operatorStart, Operator operatorEnd) {
        if (nonDefaultValue(start.intValue()) && nonDefaultValue(end.intValue())) {
            query = query.where(numberPath.between(start, end));
        } else if (nonDefaultValue(start.intValue())){
            addWhereWithComparison(numberPath, start, operatorStart);
        } else if (nonDefaultValue(end.intValue())){
            addWhereWithComparison(numberPath, end, operatorEnd);
        }
    }

    private <T extends Number & Comparable<?>>void addWhereWithComparison(NumberPath<T> numberPath, T value, Operator operator){
        if(operator.equals(Operator.GREATER_THEN)) {
            query = query.where(numberPath.goe(value));
        } else if(operator.equals(Operator.LESS_THEN)) {
            query = query.where(numberPath.loe(value));
        } else {
            query = query.where(numberPath.eq(value));
        }
    }

    private boolean nonDefaultValue(int value){
        return value != DEFAULT_INTEGER_VALUE;
    }

    private boolean nonDefaultValue(Long value){
        return !value.equals(DEFAULT_LONG_VALUE);
    }

    private boolean nonDefaultValue(Indicator value){
        return !value.equals(Indicator.DEFAULT_ENUM_VALUE);
    }

    private boolean nonDefaultValue(LengthWidthUnit value){
        return !value.equals(LengthWidthUnit.DEFAULT_ENUM_VALUE);
    }

    private boolean nonDefaultValue(AreaUnit value){
        return !value.equals(AreaUnit.DEFAULT_ENUM_VALUE);
    }

    private boolean nonDefaultValue(String value){
        return !value.equals(DEFAULT_STRING_VALUE);
    }

    private boolean nonDefaultValue(Boolean value){
        return value!= DEFAULT_BOOLEAN_VALUE;
    }
}