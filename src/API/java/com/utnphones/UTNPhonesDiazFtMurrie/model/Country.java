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
@Table(name = "countries", uniqueConstraints = {@UniqueConstraint(columnNames = {"idCountryAreaCode", "name"})})
public class Country {

    @Id
    @Column(name = "idCountry")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCountry;

    @NotNull

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCountryAreaCode")
    private CountryAreaCode countryAreaCode;

    @NotNull
    @Column(name = "name")
    private String name;

}
