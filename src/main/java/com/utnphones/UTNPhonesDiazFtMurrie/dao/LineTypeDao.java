package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.LineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineTypeDao extends JpaRepository<LineType, Integer> {



}
