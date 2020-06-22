package com.utnphones.UTNPhonesDiazFtMurrie.session;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;

import java.util.Date;


public class Session
{
    //region Properties:
    private String token;
    private User loggedUser;
    private Date lastAction;
    //endregion

    //region Constructors:
    public Session() {

    }

    public Session(String token, User loggedUser, Date lastAction) {
        this.token = token;
        this.loggedUser = loggedUser;
        this.lastAction = lastAction;
    }
    //endregion

    //region Methods:
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public Date getLastAction() {
        return lastAction;
    }

    public void setLastAction(Date lastAction) {
        this.lastAction = lastAction;
    }
    //endregion
}
