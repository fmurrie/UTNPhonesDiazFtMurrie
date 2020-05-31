package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="lineTypes")
public class LineType
{
    //Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLineType")
    private Integer idUserType;

    @NotNull
    @Column(unique = true)
    private String description;

    @NotNull
    private String code;

    @Transient
    private List<PhoneLine> phoneLineList;
}
