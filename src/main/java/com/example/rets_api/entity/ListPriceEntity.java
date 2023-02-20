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

    private NumberType lowAmount;
    private NumberType highAmount;
    private String currencyCode;
    private AreaUnit units;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

}
