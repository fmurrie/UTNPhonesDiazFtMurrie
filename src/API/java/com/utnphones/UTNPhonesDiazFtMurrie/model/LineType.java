package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="lineTypes")
public class LineType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLineType")
    private Integer idUserType;

    @NotNull
    @Column(unique = true)
    private String description;

    @NotNull
    private String code;

    @OneToMany(mappedBy = "lineTypes")
    @NotNull
    private List<PhoneLine> phoneLinesList;
}
