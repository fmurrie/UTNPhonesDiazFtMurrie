package com.utnphones.UTNPhonesDiazFtMurrie.model;

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
@Table(name = "interAreaCodes")
public class InterAreaCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInterAreaCode;

    @NotNull
    @Column(unique = true)
    private String code;

    //@NotNull
    @JsonBackReference(value = "interAreaCode-countryAreaCode")
    @OneToMany(mappedBy = "interAreaCode")
    private List<CountryAreaCode> countryAreaCodesList;

}
