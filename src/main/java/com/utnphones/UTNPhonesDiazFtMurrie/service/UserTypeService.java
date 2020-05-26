package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserTypeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class UserTypeService {

    UserTypeDao userTypeDao;

    @Autowired
    public UserTypeService(UserTypeDao userTypeDao){this.userTypeDao=userTypeDao;}

    public List<UserType> getUserType(String description) {
        if (isNull(description)){
            return userTypeDao.findAll();
        }
        else { return userTypeDao.findByDescription(description);}
    }

    public void add(final UserType userType) {
        userTypeDao.save(userType);
    }

}


