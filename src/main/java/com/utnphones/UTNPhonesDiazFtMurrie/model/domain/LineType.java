package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
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
    private Integer idLineType;

    @Column(name="description",unique=true,nullable = false,length = 100)
    private String description;

    @Column(name="code",unique=true,nullable = false,length = 100)
    private String code;

    @Transient
    private List<PhoneLine> phoneLineList;
}
