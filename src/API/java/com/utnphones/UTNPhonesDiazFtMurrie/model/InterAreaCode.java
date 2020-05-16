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
@Table(name = "interAreaCodes")
public class InterAreaCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInterAreaCode;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    @OneToMany(mappedBy = "interAreaCodes")
    private List<LocalAreaCode> localAreaCodesList;
}
