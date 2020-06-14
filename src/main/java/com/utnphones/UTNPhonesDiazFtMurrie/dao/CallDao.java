package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallDao extends JpaRepository <Call,Integer>{

}
