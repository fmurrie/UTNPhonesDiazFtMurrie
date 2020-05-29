package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.ProvinceDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {

    ProvinceDao provinceDao;

    @Autowired
    public ProvinceService(ProvinceDao provinceDao){this.provinceDao=provinceDao;}

    public void add(final Province province) { provinceDao.save(province); }

    public List<Province> getAll() { return provinceDao.findAll(); }

    public Optional<Province> getById(Integer idProvince)
    {
        return provinceDao.findById(idProvince);
    }
}
