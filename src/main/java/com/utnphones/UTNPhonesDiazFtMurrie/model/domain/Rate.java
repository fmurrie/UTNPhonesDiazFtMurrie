package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import com.utnphones.UTNPhonesDiazFtMurrie.model.compositekey.RateId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="rates")
public class Rate
{
    //region Properties:
    @EmbeddedId
    private RateId rateId;

    @MapsId("idOriginCity")//value corresponds to property in the ID class
    @ManyToOne
    @JoinColumn(name = "idOriginCity",nullable = false,insertable = false,updatable = false)
    private City idOriginCity;

    @MapsId("idDestinyCity")//value corresponds to property in the ID class
    @ManyToOne
    @JoinColumn(name = "idDestinyCity",nullable = false,insertable = false,updatable = false)
    private City idDestinyCity;

    @Column(name="minutePrice",nullable = false,insertable = false,updatable = false)
    private Float minutePrice;
    //endregion
}
