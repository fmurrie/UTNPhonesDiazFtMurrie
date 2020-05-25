package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.InterAreaCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterAreaCodeDao extends JpaRepository<InterAreaCode,Integer> {
    // @Query(value = "select i from interAreaCodes i", nativeQuery = false)
    // List<InterAreaCode> AllInterAreaCodes();

    List<InterAreaCode> findByCode(String code);
}
