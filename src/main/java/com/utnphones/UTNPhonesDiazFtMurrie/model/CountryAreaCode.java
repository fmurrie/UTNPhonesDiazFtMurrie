package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "countryAreaCodes")
public class CountryAreaCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCountryAreaCode;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idInterAreaCode")
    InterAreaCode interAreaCode;



}