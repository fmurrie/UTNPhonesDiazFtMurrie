package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="calls")
public class Call
{
    //region Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCall")
    private Integer idCall;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCallType",nullable = false,insertable = false,updatable = false)
    private CallType callType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBill",nullable = true,insertable = false,updatable = false)
    private Bill bill;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPhoneLineOrigin",nullable = false)
    private PhoneLine phoneLineOrigin ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPhoneLineDestiny",nullable = false)
    private PhoneLine phoneLineDestiny ;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name="initTime",nullable = false)
    private Date initTime;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name="endTime",nullable = false)
    private Date endTime;

    @Column(name="durationSeconds",insertable = false,updatable = false)
    private Float durationSeconds;

    @Column(name="totalPrice",insertable = false,updatable = false)
    private Float totalPrice;
    //endregion
}
