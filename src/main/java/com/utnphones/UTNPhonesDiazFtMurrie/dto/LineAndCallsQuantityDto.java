package com.utnphones.UTNPhonesDiazFtMurrie.dto;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineAndCallsQuantityDto {

    @NotNull
    private PhoneLine favoritePhoneLine;

    @NotNull
    private Integer callsQuantity;
}
