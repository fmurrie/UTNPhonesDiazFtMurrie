package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "countries")
public class Country
{
    //Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCountry;

    @NotNull
    @Column(unique=true)
    private String iso;

    @NotNull
    @Column(unique=true)
    private String name;

    @NotNull
    private String areaCode;

    @Transient
    private List<Province> provinceList;
}
