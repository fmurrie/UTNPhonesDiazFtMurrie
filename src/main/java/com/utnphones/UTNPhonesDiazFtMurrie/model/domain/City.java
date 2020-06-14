package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    //Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCity")
    private Integer idCity;

    @Column(name="name",unique=true,nullable = false,length = 100)
    private String name;

    @Column(name="areaCode",nullable = false,length = 100)
    private String areaCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "province-country")
    @JoinColumn(name = "idProvince",nullable = false)
    private Province province;
}
