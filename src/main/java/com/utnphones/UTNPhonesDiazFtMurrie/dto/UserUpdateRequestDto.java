package com.utnphones.UTNPhonesDiazFtMurrie.dto;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserUpdateRequestDto
{
    //region Properties:
    @NotNull
    private String dni;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @ManyToOne
    private City city;

    @NotNull
    private String username;

    @NotNull
    private String userpassword;
    //endregion
}
