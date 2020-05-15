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
@Table(name="billStates")
public class BillState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBillState;

    @NotNull
    @Column(unique = true)
    private String description;

}

