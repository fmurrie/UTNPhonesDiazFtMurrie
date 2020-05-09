package com.utnphones.UTNPhonesDiazFtMurrie.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="provinces", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "idCountry"})})
public class Province {
    @Id
    @GeneratedValue
    @Column(name="idProvince")
    private Integer idProvince;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCountry")
    private Country country;


}
