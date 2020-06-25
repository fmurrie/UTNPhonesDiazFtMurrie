package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import javax.persistence.*;
import java.util.List;

@Entity
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="billStates")
public class BillState
{
    //region Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBillState")
    private Integer idBillState;

    @Column(name="description",unique=true,nullable = false,length = 100,insertable = false,updatable = false)
    private String description;

    @Transient
    private List<Bill> billList;
    //endregion
}