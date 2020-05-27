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
@Table(name="userTypes")
public class UserType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserType;

    @NotNull
    @Column(unique = true)
    private String description;

    @Transient
    private List<User> userList;
}
