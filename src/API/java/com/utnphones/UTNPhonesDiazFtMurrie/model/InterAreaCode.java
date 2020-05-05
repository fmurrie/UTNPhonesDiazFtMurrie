package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "interAreaCodes")
public class InterAreaCode {
    @Id
    @Column(name = "idInterAreaCode")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idInterAreaCode;

    @NotNull
    @Column(name = "code")
    private String code;
}
