package com.utnphones.UTNPhonesDiazFtMurrie.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="provinces", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "idCountry"})})
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProvince;

    @NotNull
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCountry")
    private Country country;

    @NotNull
    @OneToMany(mappedBy = "provinces")
    private List<City> citiesList;



}
