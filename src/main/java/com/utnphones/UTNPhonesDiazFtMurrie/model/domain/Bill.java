package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="bills",uniqueConstraints = {@UniqueConstraint(columnNames = {"idPhoneLine", "billMonth"})})
public class Bill
{
    //Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBill")
    private Integer idBill;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBillState",nullable = false,insertable = false)
    private BillState billState;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPhoneLine",nullable = false,insertable = false,updatable = false)
    private PhoneLine phoneLine ;

    @Column(name = "callsQuantity",nullable = false,insertable = false,updatable = false)
    private Integer callsQuantity;

    @Column(name = "costPrice",nullable = false,insertable = false,updatable = false)
    private Float costPrice;

    @Column(name = "totalPrice",nullable = false,insertable = false,updatable = false)
    private Float totalPrice;

    @Column(name = "billMonth",nullable = false,insertable = false,updatable = false)
    private String billMonth;

    @Column(name = "issueDate",nullable = false,insertable = false,updatable = false)
    private Date issueDate;

    @Column(name = "expiryDate",nullable = false,insertable = false,updatable = false)
    private Date expiryDate;

    @Column(name = "expired",nullable = false,insertable = false,updatable = false)
    private boolean expired;

    @Transient
    private List<Call> callList;
}