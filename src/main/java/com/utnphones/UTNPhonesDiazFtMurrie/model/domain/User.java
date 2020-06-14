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
    //Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer idUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUserType",nullable = false)
    private UserType userType;

    @Column(name="dni",unique=true,nullable = false,length = 100)
    private String dni;

    @Column(name="firstName",nullable = false,length = 100)
    private String firstName;

    @Column(name="lastName",nullable = false,length = 100)
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCity",nullable = false)
    private City city;

    @Column(name="username",unique=true,nullable = false,length = 100)
    private String username;

    @NotNull
    @Column(name="userpassword",nullable = false,length = 100)
    private String userpassword;

    @OneToMany(mappedBy = "user")
    private List<PhoneLine> phoneLines;
}
