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
@Table(name="callTypes")
public class CallType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCallType;

    @NotNull
    @Column(unique = true)
    private String description;

    @NotNull
    private Float minutePrice;
}
