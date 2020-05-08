package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.ProvinceDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class ProvinceService {

    ProvinceDao provinceDao;

    @Autowired
    public ProvinceService(ProvinceDao provinceDao){this.provinceDao=provinceDao;}

    public List<Province> getProvince(String name) {
        if (isNull(name)){
            return provinceDao.findAll();
        }
        else { return provinceDao.findByName(name);}
    }

    public void add(final Province province) {
        provinceDao.save(province);
    }
}
