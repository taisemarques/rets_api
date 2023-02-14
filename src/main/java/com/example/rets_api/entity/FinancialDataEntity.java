package com.example.rets_api.entity;

import lombok.*;

import javax.persistence.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinancialDataEntity)) return false;
        FinancialDataEntity that = (FinancialDataEntity) o;
        return Objects.equals(getLeaseOption(), that.getLeaseOption()) && getLeaseIndicator() == that.getLeaseIndicator() && Objects.equals(getTradeOption(), that.getTradeOption()) && getTradeIndicator() == that.getTradeIndicator() && Objects.equals(getRentalAmount(), that.getRentalAmount()) && getRentalAmountType() == that.getRentalAmountType() && Objects.equals(getRentalAmountCurrencyCode(), that.getRentalAmountCurrencyCode()) && getRentalAmountPeriod() == that.getRentalAmountPeriod() && getRentalAmountUnit() == that.getRentalAmountUnit();
    }
}
