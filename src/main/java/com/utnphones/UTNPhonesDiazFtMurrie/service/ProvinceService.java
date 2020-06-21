package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.ProvinceDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {
    //region Properties:
    private final ProvinceDao dao;
    //endregion

    //region Constructors:
    @Autowired
    public ProvinceService(ProvinceDao dao){this.dao = dao;}
    //endregion

    //region Methods:
    public List<Province> getAll() { return dao.findAll(); }

    public Optional<Province> getById(Integer id)
    {
        return dao.findById(id);
    }
    //endregion
}
