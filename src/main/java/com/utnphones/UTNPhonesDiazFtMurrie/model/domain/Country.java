package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
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
    @Column(name="idCountry")
    private Integer idCountry;

    @Column(name="iso",unique=true,nullable = false,length = 100)
    private String iso;

    @Column(name="name",unique=true,nullable = false,length = 100)
    private String name;

    @Column(name="areaCode",unique=true,nullable = false,length = 100)
    private String areaCode;

    @Transient
    private List<Province> provinceList;
}
