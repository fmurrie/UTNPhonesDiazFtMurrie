package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.LocalAreaCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalAreaCodeDao extends JpaRepository <LocalAreaCode,Integer> {

    public List<LocalAreaCode> findByCode(String code);
}
