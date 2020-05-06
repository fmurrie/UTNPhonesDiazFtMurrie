package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.CountryAreaCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryAreaCodeDao  extends JpaRepository<CountryAreaCode,Integer> {
}
