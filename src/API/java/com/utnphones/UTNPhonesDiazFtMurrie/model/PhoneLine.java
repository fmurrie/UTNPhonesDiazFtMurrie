package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="phoneLines", uniqueConstraints = {@UniqueConstraint(columnNames = {"idLocalAreaCode", "phoneNumber"})})
public class PhoneLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPhoneLine;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idLineType")
    private LineType lineType;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idLocalAreaCode")
    private LocalAreaCode localAreaCode ;

    @NotNull
    private String phoneNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private User user;

}
