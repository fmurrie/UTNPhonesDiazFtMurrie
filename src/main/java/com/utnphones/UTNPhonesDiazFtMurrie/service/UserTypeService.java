package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserTypeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService {
    //region Properties:
    private final UserTypeDao dao;
    //endregion

    //region Constructors:
    @Autowired
    public UserTypeService(UserTypeDao dao){this.dao = dao;}
    //endregion

    //region Methods:
    public UserType add(final UserType userType) {
        return dao.save(userType);
    }

    public List<UserType> getAll()
    {
        return dao.findAll();
    }

    public UserType getById(Integer id)
    {
        return dao.getById(id);
    }
    //endregion
}


