package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="phoneLines")
public class PhoneLine
{
    //Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPhoneLine")
    private Integer idPhoneLine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idLineType",nullable = false)
    private LineType lineType;

    @Column(name="phoneNumber",unique=true,nullable = false,length = 100)
    private String phoneNumber;

    @NotNull
    @ManyToOne
    @JsonBackReference(value = "phoneLine-user")
    @JoinColumn(name = "idUser",nullable = false)
    private User user;

    @Transient
    private List<Call> callList;
}