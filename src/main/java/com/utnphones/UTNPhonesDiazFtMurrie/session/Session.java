package com.utnphones.UTNPhonesDiazFtMurrie.session;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Session
{
    //region Properties:
    private String token;
    private User loggedUser;
    private Date lastAction;
    //endregion
}
