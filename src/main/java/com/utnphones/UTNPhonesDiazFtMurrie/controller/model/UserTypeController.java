package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import com.utnphones.UTNPhonesDiazFtMurrie.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;


@Controller
public class UserTypeController {
    //region Properties:
    private final UserTypeService service;
    //endregion

    //region Constructors:
    @Autowired
    public UserTypeController(UserTypeService service) {

        this.service = service;
    }
    //endregion

    //region Methods:
    public List<UserType> getAllUserTypes()
    {
        return service.getAll();
    }

    public Optional<UserType> getUserTypeById(Integer idUserType)
    {
        return service.getById(idUserType);
    }
    //endregion
}
