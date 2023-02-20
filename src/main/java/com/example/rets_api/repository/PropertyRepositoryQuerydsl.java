package com.example.rets_api.repository;
import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.*;
import com.example.rets_api.resource.Enums.*;
import com.example.rets_api.resource.PropertyFilter;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.rets_api.resource.Constants.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.springframework.util.ObjectUtils.isEmpty;

@Repository
public class PropertyRepositoryQuerydsl extends QuerydslRepositorySupport {

    public PropertyRepositoryQuerydsl() {
        super(PropertyEntity.class);
    }

    public List<PropertyEntity> fetchAll(PropertyFilter filterParams) {
        QPropertyEntity property = QPropertyEntity.propertyEntity;
        QRoomEntity room = QRoomEntity.roomEntity;
        QSchoolEntity school = QSchoolEntity.schoolEntity;
        QViewDataEntity viewData = QViewDataEntity.viewDataEntity;
        QFinancialDataEntity financialData = QFinancialDataEntity.financialDataEntity;
        QAnimalPolicyEntity animalPolicy = QAnimalPolicyEntity.animalPolicyEntity;
        QLotDataEntity lotData = QLotDataEntity.lotDataEntity;
        QCommunityEntity community = QCommunityEntity.communityEntity;
        QListPriceEntity listPrice = QListPriceEntity.listPriceEntity;
        QContactInformationEntity contactInformation = QContactInformationEntity.contactInformationEntity;
        QPhoneEntity agentPhone = new QPhoneEntity("agentPhone");
        QPhoneEntity listAgentPhone = new QPhoneEntity("listAgentPhone");
        QPhoneEntity officePhone = new QPhoneEntity("officePhone");
        QPhoneEntity listOfficePhone = new QPhoneEntity("listOfficePhone");
        QPhoneEntity salesAgentPhone = new QPhoneEntity("salesAgentPhone");
        QPhoneEntity salesOfficePhone = new QPhoneEntity("salesOfficePhone");


        // Joining tables
        JPQLQuery<PropertyEntity> query = from(property).distinct()
                .leftJoin(room).on(property.roomList.contains(room))
                .leftJoin(school).on(property.schoolList.contains(school))
                .leftJoin(viewData).on(property.propertyId.eq(viewData.property.propertyId))
                .leftJoin(financialData).on(property.propertyId.eq(financialData.property.propertyId))
                .leftJoin(animalPolicy).on(property.animalPolicy.eq(animalPolicy))
                .leftJoin(lotData).on(property.lotData.eq(lotData))
                .leftJoin(community).on(property.community.eq(community))
                .leftJoin(listPrice).on(property.propertyId.eq(listPrice.property.propertyId))
                .leftJoin(contactInformation).on(property.contactInformation.contactInformationId.eq(contactInformation.contactInformationId))
                .leftJoin(agentPhone).on(contactInformation.agentPhone.phoneId.eq(agentPhone.phoneId))
                .leftJoin(listAgentPhone).on(contactInformation.listAgentPhone.phoneId.eq(listAgentPhone.phoneId))
                .leftJoin(officePhone).on(contactInformation.officePhone.phoneId.eq(officePhone.phoneId))
                .leftJoin(listOfficePhone).on(contactInformation.listOfficePhone.phoneId.eq(listOfficePhone.phoneId))
                .leftJoin(salesAgentPhone).on(contactInformation.salesAgentPhone.phoneId.eq(salesAgentPhone.phoneId))
                .leftJoin(salesOfficePhone).on(contactInformation.salesOfficePhone.phoneId.eq(salesOfficePhone.phoneId));

        if(filterParams.getPropertyAge() != DEFAULT_NUMBER_VALUE)
            query = query.where(property.age.eq(filterParams.getPropertyAge()));

        if(!filterParams.getPropertyHorseFacilitiesDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.horseFacilities.likeIgnoreCase(filterParams.getPropertyHorseFacilitiesDescription()));

        if(!filterParams.getPropertyHorseFacilitiesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.horseFacilitiesIndicator.eq(filterParams.getPropertyHorseFacilitiesIndicator()));

        if(!filterParams.getPropertyHotTubDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.hotTub.likeIgnoreCase(filterParams.getPropertyHotTubDescription()));

        if(!filterParams.getPropertyHotTubIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.hotTubIndicator.eq(filterParams.getPropertyHotTubIndicator()));

        if(!filterParams.getPropertyTennisCourtDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.tennisCourt.likeIgnoreCase(filterParams.getPropertyTennisCourtDescription()));

        if(!filterParams.getPropertyTennisCourtIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.tennisCourtIndicator.eq(filterParams.getPropertyTennisCourtIndicator()));

        if(!filterParams.getPropertyInclusionsDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.inclusions.likeIgnoreCase(filterParams.getPropertyInclusionsDescription()));

        if(!filterParams.getPropertyEnergyInformationDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.energyInformation.likeIgnoreCase(filterParams.getPropertyEnergyInformationDescription()));

        if(!filterParams.getPropertyConstructionMaterialDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.constructionMaterial.likeIgnoreCase(filterParams.getPropertyConstructionMaterialDescription()));

        if(!filterParams.getPropertyDisabilityFeaturesDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.disabilityFeatures.likeIgnoreCase(filterParams.getPropertyDisabilityFeaturesDescription()));

        if(!filterParams.getPropertyDisabilityFeaturesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.disabilityFeaturesIndicator.eq(filterParams.getPropertyDisabilityFeaturesIndicator()));

        if(!filterParams.getPropertySecurityFeaturesDescription().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.securityFeatures.likeIgnoreCase(filterParams.getPropertySecurityFeaturesDescription()));

        if(!filterParams.getPropertySecurityFeaturesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.securityFeaturesIndicator.eq(filterParams.getPropertySecurityFeaturesIndicator()));

        if(nonNull(filterParams.getPropertyTypeRental()))
            query = query.where(property.propertyTypeRental.eq(filterParams.getPropertyTypeRental()));

        if(nonNull(filterParams.getPropertyTypeCondo()))
            query = query.where(property.propertyTypeCondo.eq(filterParams.getPropertyTypeCondo()));

        if(nonNull(filterParams.getPropertyTypeFarm()))
            query = query.where(property.propertyTypeFarm.eq(filterParams.getPropertyTypeFarm()));

        if(nonNull(filterParams.getPropertyTypeTownHouse()))
            query = query.where(property.propertyTypeTownHouse.eq(filterParams.getPropertyTypeTownHouse()));

        if(filterParams.getPropertyBedroomsQty() != DEFAULT_NUMBER_VALUE)
            query = query.where(property.bedroomsQty.eq(filterParams.getPropertyBedroomsQty()));

        if(filterParams.getPropertyBathroomsQty() != DEFAULT_NUMBER_VALUE)
            query = query.where(property.bathroomsQty.eq(filterParams.getPropertyBathroomsQty()));

        if(nonNull(filterParams.getPropertyTypeTownHouse()))
            query = query.where(property.propertyTypeTownHouse.eq(filterParams.getPropertyTypeTownHouse()));

        if(!isEmpty(filterParams.getPropertyBathSizes())){
            BooleanBuilder builder = new BooleanBuilder();
            for(BathSize bathSize: filterParams.getPropertyBathSizes()) {
                if(!bathSize.equals(BathSize.DEFAULT_ENUM_VALUE)) {
                    if (bathSize.equals(BathSize.FULL)) {
                        builder = builder.or(room.roomType.eq(RoomType.MASTER_BEDROOM).orAllOf(room.roomType.eq(RoomType.MAIN_FLOOR_BATHROOM), room.bathSize.eq(bathSize)));
                    } else {
                        builder = builder.or(room.bathSize.eq(bathSize).and(room.roomType.eq(RoomType.MAIN_FLOOR_BATHROOM)));
                    }
                }
                query = query.where(builder);
            }
        }

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

        if(!filterParams.getViewDataCityLightIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.cityLightIndicator.eq(filterParams.getViewDataCityLightIndicator()));

        if(!filterParams.getViewDataMountainIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.mountainIndicator.eq(filterParams.getViewDataMountainIndicator()));

        if(!filterParams.getViewDataRiverIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.riverIndicator.eq(filterParams.getViewDataRiverIndicator()));

        if(!filterParams.getViewDataLakeIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.lakeIndicator.eq(filterParams.getViewDataLakeIndicator()));

        if(!filterParams.getViewDataGolfCourseIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.golfCourseIndicator.eq(filterParams.getViewDataGolfCourseIndicator()));

        if(!filterParams.getViewDataWaterIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(viewData.waterIndicator.eq(filterParams.getViewDataWaterIndicator()));

        if(!filterParams.getFinancialDataTradeIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(financialData.tradeIndicator.eq(filterParams.getFinancialDataTradeIndicator()));

        if(!filterParams.getFinancialDataLeaseIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(financialData.leaseIndicator.eq(filterParams.getFinancialDataLeaseIndicator()));

        if(!filterParams.getFinancialDataRentalAmount().equals(DEFAULT_LONG_VALUE))
            query = query.where(financialData.rentalAmount.eq(filterParams.getFinancialDataRentalAmount()));

        if(!filterParams.getAnimalPolicyAnimalPermitted().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(animalPolicy.animalsPermitted.eq(filterParams.getAnimalPolicyAnimalPermitted()));

        if(!filterParams.getLotDataGolfCourseLotIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(lotData.golfCourseLotIndicator.eq(filterParams.getLotDataGolfCourseLotIndicator()));

        if(!filterParams.getLotDataCuldeSacIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(lotData.culdeSacIndicator.eq(filterParams.getLotDataCuldeSacIndicator()));

        if(!filterParams.getLotDataCornerLotIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(lotData.cornerLotIndicator.eq(filterParams.getLotDataCornerLotIndicator()));

        if(!filterParams.getCommunityClubHouseIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.clubHouseIndicator.eq(filterParams.getCommunityClubHouseIndicator()));

        if(!filterParams.getCommunityExerciseAreaIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.exerciseAreaIndicator.eq(filterParams.getCommunityExerciseAreaIndicator()));

        if(!filterParams.getCommunityGolfIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.golfIndicator.eq(filterParams.getCommunityGolfIndicator()));

        if(!filterParams.getCommunityTennisIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.tennisIndicator.eq(filterParams.getCommunityTennisIndicator()));

        if(!filterParams.getCommunityRecreationalFacilitiesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.recreationalFacilitiesIndicator.eq(filterParams.getCommunityRecreationalFacilitiesIndicator()));

        if(!filterParams.getCommunitySecurityFeaturesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.securityFeaturesIndicator.eq(filterParams.getCommunitySecurityFeaturesIndicator()));

        if(!filterParams.getCommunitySeniorCommunityIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.seniorCommunityIndicator.eq(filterParams.getCommunitySeniorCommunityIndicator()));

        if(!filterParams.getCommunityHotTubIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.hotTubIndicator.eq(filterParams.getCommunityHotTubIndicator()));

        if(!filterParams.getCommunityPoolIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.poolIndicator.eq(filterParams.getCommunityPoolIndicator()));

        if(!filterParams.getCommunityBoatFacilitiesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.boatFacilitiesIndicator.eq(filterParams.getCommunityBoatFacilitiesIndicator()));

        if(!filterParams.getCommunityHorseFacilitiesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.horseFacilitiesIndicator.eq(filterParams.getCommunityHorseFacilitiesIndicator()));

        if(!filterParams.getCommunityParkIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(community.communityParkIndicator.eq(filterParams.getCommunityParkIndicator()));

        List<String> phoneNumbers = filterParams.getContactInformationPhoneNumbers();
        if(!isEmpty(phoneNumbers)){
            BooleanBuilder builder = new BooleanBuilder();
            builder = builder.or(agentPhone.primaryPhone.in(phoneNumbers))
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

        if(!filterParams.getLowAmount().equals(DEFAULT_LONG_VALUE))
            query = query.where(listPrice.lowAmount.goe(filterParams.getLowAmount()));

        if(!filterParams.getHighAmount().equals(DEFAULT_LONG_VALUE))
            query = query.where(listPrice.highAmount.loe(filterParams.getHighAmount()));

        if(!filterParams.getLowAmountType().equals(NumberType.DEFAULT_ENUM_VALUE))
            query = query.where(listPrice.lowAmountType.eq(filterParams.getLowAmountType()));

        if(!filterParams.getHighAmountType().equals(NumberType.DEFAULT_ENUM_VALUE))
            query = query.where(listPrice.highAmountType.eq(filterParams.getHighAmountType()));

        if(!filterParams.getLowAmountCurrencyCode().equals(DEFAULT_STRING_VALUE))
            query = query.where(listPrice.lowAmountCurrencyCode.equalsIgnoreCase(filterParams.getLowAmountCurrencyCode()));

        if(!filterParams.getHighAmountCurrencyCode().equals(DEFAULT_STRING_VALUE))
            query = query.where(listPrice.highAmountCurrencyCode.equalsIgnoreCase(filterParams.getHighAmountCurrencyCode()));

        if(!filterParams.getListPriceUnits().equals(AreaUnit.DEFAULT_ENUM_VALUE))
            query = query.where(listPrice.units.eq(filterParams.getListPriceUnits()));

        return query.fetch();
    }
}
