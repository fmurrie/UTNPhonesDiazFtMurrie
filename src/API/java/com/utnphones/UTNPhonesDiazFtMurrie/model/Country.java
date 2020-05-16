package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "countries", uniqueConstraints = {@UniqueConstraint(columnNames = {"idCountryAreaCode", "name"})})
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCountry;

    @NotNull

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCountryAreaCode")
    private CountryAreaCode countryAreaCode;

    @NotNull
    private String name;

    @NotNull
    @OneToMany(mappedBy = "countries")
    private List<Province> provincesList;


}
