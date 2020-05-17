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
@Table(name="rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRate;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "idLocalAreaCode")
    private LocalAreaCode localAreaCode;

    @NotNull
    @OneToMany(mappedBy = "rates")
    @JoinColumn(name = "idOriginCity")
    private City originCity;

    @NotNull
    @OneToMany(mappedBy = "rates")
    @JoinColumn(name = "idDestinyCity")
    private City destinyCity;

    @NotNull
    private Float minutePrice;
}
