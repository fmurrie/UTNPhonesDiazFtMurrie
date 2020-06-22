package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.compositekey.RateId;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateDao extends JpaRepository<Rate, RateId> { }
