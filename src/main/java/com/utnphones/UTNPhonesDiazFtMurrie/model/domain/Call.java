package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

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
    //Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCall;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBill")
    private Bill bill;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPhoneLineOrigin")
    private PhoneLine phoneLineOrigin ;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPhoneLineDestiny")
    private PhoneLine phoneLineDestiny ;

    @NotNull
    private Date initTime;

    @NotNull
    private Date endTime;

    @NotNull
    private Float durationSeconds;

    @NotNull
    private Float totalPrice;
}
