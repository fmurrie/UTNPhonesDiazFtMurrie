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
    //Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBillState")
    private Integer idBillState;

    @Column(name="description",unique=true,nullable = false,length = 100)
    private String description;

    @Transient
    private List<Bill> billList;
}