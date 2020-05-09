package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="cities", uniqueConstraints = {@UniqueConstraint(columnNames = {"", ""})})
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCity")
    private Integer idCity;

    @NotNull
    @Column(name = "idLocalAreaCode")
    private LocalAreaCode localAreaCode;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "idProvince")
    private Province province;


}
