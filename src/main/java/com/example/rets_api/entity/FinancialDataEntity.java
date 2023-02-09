package com.example.rets_api.entity;

import lombok.*;

import javax.persistence.*;

import static com.example.rets_api.resource.Enums.*;

@Entity(name = "financial_data")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FinancialDataEntity {

    @Id
    @GeneratedValue
    @Column(name="financial_data_id")
    private Long financialDataId;

    private String leaseOption;

    private Indicator leaseIndicator;

    private String tradeOption;

    private Indicator tradeIndicator;

    private Long rentalAmount;

    private NumberType rentalAmountType;

    private String rentalAmountCurrencyCode;

    private RentalPeriod rentalAmountPeriod;

    private AreaUnit rentalAmountUnit;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

}
