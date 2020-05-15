package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUserType")
    private UserType userType;

    @NotNull
    @Column(unique = true)
    private String dni;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCity")
    private City city;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @Column(name = "userpassword")
    private String userPassword;

    @NotNull
    @OneToMany(mappedBy = "users")
    private List<PhoneLine> phoneLines;


}
