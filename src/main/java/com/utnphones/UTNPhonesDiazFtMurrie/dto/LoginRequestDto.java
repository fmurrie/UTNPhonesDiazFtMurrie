package com.utnphones.UTNPhonesDiazFtMurrie.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequestDto
{
    //region Properties:
    String username;
    String userpassword;
    //endregion
}
