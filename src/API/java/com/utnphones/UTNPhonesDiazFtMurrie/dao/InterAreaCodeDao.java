package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.model.InterAreaCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterAreaCodeDao extends JpaRepository<InterAreaCode,Integer> {
}
