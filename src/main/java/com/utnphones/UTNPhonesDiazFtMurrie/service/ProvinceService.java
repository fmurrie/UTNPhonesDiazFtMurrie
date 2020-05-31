package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.ProvinceDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {
    //Properties:
    private final ProvinceDao dao;

    //Constructors:
    @Autowired
    public ProvinceService(ProvinceDao dao){this.dao = dao;}

    //Methods:
    public void add(final Province province) { dao.save(province); }

    public List<Province> getAll() { return dao.findAll(); }

    public Optional<Province> getById(Integer id)
    {
        return dao.findById(id);
    }
}
