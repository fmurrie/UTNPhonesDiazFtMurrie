package com.utnphones.UTNPhonesDiazFtMurrie.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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
    //@JsonIgnoreProperties("country")
    @OneToMany(mappedBy = "country", orphanRemoval = true)
    private List<Province> provincesList;
}
