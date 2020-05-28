package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

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
@Table(name="users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer idUser;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUserType")
    private UserType userType;

    @NotNull
    @Column(name="dni",unique = true)
    private String dni;

    @NotNull
    @Column(name="firstName")
    private String firstName;

    @NotNull
    @Column(name="lastName")
    private String lastName;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCity")
    private City city;

    @NotNull
    @Column(name="username",unique = true)
    private String username;

    @NotNull
    @Column(name="userpassword")
    private String userpassword;
}
