package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CountryAreaCode {

    @Id
    @GeneratedValue
    private Integer idCountryAreaCode;

    @NotNull
    private String code;

    @NotNull
    InterAreaCode interAreaCode;

}


