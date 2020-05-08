package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.CountryAreaCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryAreaCodeDao  extends JpaRepository<CountryAreaCode,Integer> {
    List<CountryAreaCode> findByCode(String code);
}
