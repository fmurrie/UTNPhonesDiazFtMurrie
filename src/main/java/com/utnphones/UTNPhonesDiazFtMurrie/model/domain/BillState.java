package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="billStates")
public class BillState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBillState;

    @NotNull
    @Column(unique = true)
    private String description;

    @Transient
    private List<Bill> billList;
}