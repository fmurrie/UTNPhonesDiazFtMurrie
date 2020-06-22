package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="callTypes")
public class CallType {
    //region Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCallType")
    private Integer idCallType;

    @Column(name="description",unique=true,nullable = false,length = 100)
    private String description;

    @Column(name="minutePrice",nullable = false,insertable = false,updatable = false)
    private Float minutePrice;

    @Column(name="cost",nullable = false,insertable = false,updatable = false)
    private Float cost;

    @Column(name="valueAdded",nullable = false,insertable = false,updatable = false)
    private Float valueAdded;
    //endregion
}
