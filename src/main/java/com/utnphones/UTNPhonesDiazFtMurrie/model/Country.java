package com.utnphones.UTNPhonesDiazFtMurrie.model;

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
public class Country {

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

    @NotNull
    @OneToMany(mappedBy = "country", orphanRemoval = true)
    private List<Province> provincesList;
}
