package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="provinces", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "idCountry"})})
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProvince;

    @NotNull
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "province-country")
    @JoinColumn(name = "idCountry")
    private Country country;

    @Transient
    private List<City> cityList;
}