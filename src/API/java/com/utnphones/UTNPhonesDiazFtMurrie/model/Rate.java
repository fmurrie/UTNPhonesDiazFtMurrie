/*package com.utnphones.UTNPhonesDiazFtMurrie.model;

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
@Table(name="rates", uniqueConstraints = {@UniqueConstraint(columnNames = {"", ""})})
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRate;

    @NotNull
    @Column(name = "idLocalAreaCode")
    private LocalAreaCode localAreaCode;

    @NotNull
    @JoinColumn(name = "idOriginCity")
    private City originCity;

    @NotNull
    @JoinColumn(name = "idDestinyCity")
    private City destinyCity;

    @NotNull
    private Float minutePrice;
}*/
