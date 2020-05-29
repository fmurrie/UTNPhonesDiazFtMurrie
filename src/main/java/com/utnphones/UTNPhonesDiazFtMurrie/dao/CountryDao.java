package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDao extends JpaRepository<Country,Integer> {
}
