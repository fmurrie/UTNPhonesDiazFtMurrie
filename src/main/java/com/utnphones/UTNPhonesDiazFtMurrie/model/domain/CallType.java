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
    private Integer idCallType;

    @NotNull
    @Column(unique = true)
    private String description;

    @NotNull
    private Float minutePrice;
}
