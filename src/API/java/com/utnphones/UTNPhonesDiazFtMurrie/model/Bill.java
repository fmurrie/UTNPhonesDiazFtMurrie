package com.utnphones.UTNPhonesDiazFtMurrie.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="bills",uniqueConstraints = {@UniqueConstraint(columnNames = {"idPhoneLine", "billMonth"})})
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBill;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBillState")
    private BillState billState;//default 0

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPhoneLine")
    private PhoneLine phoneLine ;

    @NotNull
    private Integer callsQuantity;

    @NotNull
    private Float costPrice;

    @NotNull
    private Float totalPrice;

    @NotNull
    private String billMonth;

    @NotNull
    private Date issueDate;//default now

    @NotNull
    private Float expiryDate;

}
