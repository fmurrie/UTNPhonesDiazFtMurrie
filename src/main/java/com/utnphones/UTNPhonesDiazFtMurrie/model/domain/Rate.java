package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import com.utnphones.UTNPhonesDiazFtMurrie.model.compositekey.RateId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="rates")
public class Rate
{
    @EmbeddedId
    private RateId rateId;

    @MapsId("idOriginCity")//value corresponds to property in the ID class
    @ManyToOne
    @JoinColumn(name = "idOriginCity")
    private City idOriginCity;

    @MapsId("idDestinyCity")//value corresponds to property in the ID class
    @ManyToOne
    @JoinColumn(name = "idDestinyCity")
    private City idDestinyCity;

    @NotNull
    private Float minutePrice;
}
