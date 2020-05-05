package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "idCountry")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCountry;

    @NotNull
    @OneToOne
    @JoinColumn(name = "idCountryAreaCode")
    private CountryAreaCode countryAreaCode;

    @NotNull
    @Column(name = "name")
    private String name;

}
