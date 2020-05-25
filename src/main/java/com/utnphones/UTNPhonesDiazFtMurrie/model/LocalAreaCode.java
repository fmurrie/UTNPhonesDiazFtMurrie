package com.utnphones.UTNPhonesDiazFtMurrie.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "localAreaCodes")
public class LocalAreaCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLocalAreaCode;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idInterAreaCode")
    InterAreaCode interAreaCode;

    //@NotNull
    @JsonBackReference(value = "localAreaCode-city")
    @OneToMany(mappedBy = "localAreaCode")
    private List<City> citiesList;

}
