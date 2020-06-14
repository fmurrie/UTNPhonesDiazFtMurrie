package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="callTypes")
public class CallType {
    //Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCallType")
    private Integer idCallType;

    @Column(name="description",unique=true,nullable = false,length = 100)
    private String description;

    @Column(name="minutePrice",nullable = false)
    private Float minutePrice;
}
