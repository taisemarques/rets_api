package com.example.rets_api.entity;

import com.example.rets_api.resource.Enums.*;
import lombok.*;

import javax.persistence.*;

@Entity(name = "list_price")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ListPriceEntity {

    @Id
    @GeneratedValue
    @Column(name = "list_price_id")
    private Long listPriceId;

    private Long lowAmount;
    private Long highAmount;
    private NumberType lowAmountType;
    private NumberType highAmountType;
    private String lowAmountCurrencyCode;
    private String highAmountCurrencyCode;
    private AreaUnit units;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

}
