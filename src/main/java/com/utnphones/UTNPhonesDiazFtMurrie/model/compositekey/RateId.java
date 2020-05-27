package com.utnphones.UTNPhonesDiazFtMurrie.model.compositekey;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RateId
{
    @NotNull
    private City idOriginCity;

    @NotNull
    private City idDestinyCity;
}
