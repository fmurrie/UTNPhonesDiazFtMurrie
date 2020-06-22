package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CallDao extends JpaRepository <Call,Integer>
{
    //region Methods:
    @Query(value = "select * from calls c inner join phoneLines pl on pl.idPhoneLine = c.idPhoneLineOrigin where pl.idUser = ?1", nativeQuery = true)
    List<Call> getCallsByUser(Integer userId);

    @Query(value = "select * FROM calls c inner join phoneLines pl on pl.idPhoneLine = c.idPhoneLineOrigin where pl.idUser = ?1 and c.initTime between ?2 and ?3", nativeQuery = true)
    List<Call> getCallsBetweenDates(Integer userId, Date fromDate, Date toDate);
    //endregion
}
