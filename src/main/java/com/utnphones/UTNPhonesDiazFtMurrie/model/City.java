package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="cities", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "idProvince"})})
public class City
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCity;

    @NotNull
    private String name;

    @NotNull
    private String areaCode;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProvince")
    private Province province;
}
