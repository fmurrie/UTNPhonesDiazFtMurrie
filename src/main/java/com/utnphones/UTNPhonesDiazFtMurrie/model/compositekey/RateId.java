package com.utnphones.UTNPhonesDiazFtMurrie.model.compositekey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RateId implements Serializable
{
    //Properties:
    @NotNull
    private Integer idOriginCity;

    @NotNull
    private Integer idDestinyCity;
}
