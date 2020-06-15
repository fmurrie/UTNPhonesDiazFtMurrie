package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="provinces", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "idCountry"})})
public class Province
{
    //Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProvince")
    private Integer idProvince;

    @Column(name="name",unique=true,nullable = false,length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "province-country")
    @JoinColumn(name = "idCountry",nullable = false)
    private Country country;

    @Transient
    private List<City> cityList;
}