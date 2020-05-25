package com.utnphones.UTNPhonesDiazFtMurrie.model;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @NotNull
    @JsonBackReference(value = "billState-bill")
    @OneToMany(mappedBy = "billState")
    private List<Bill> billsList;
}