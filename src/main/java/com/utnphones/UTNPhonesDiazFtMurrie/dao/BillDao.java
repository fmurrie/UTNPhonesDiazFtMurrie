package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BillDao extends JpaRepository<Bill, Integer>
{
    //region Methods:
    @Query(value = "select * from bills b inner join phoneLines pl on pl.idPhoneLine = b.idPhoneLine where pl.idUser = ?1", nativeQuery = true)
    List<Bill> getBillsByUser(Integer userId);

    @Query(value = "select * from bills b inner join phoneLines pl on pl.idPhoneLine = b.idPhoneLine where pl.idUser = ?1 and b.issueDate between ?2 and ?3", nativeQuery = true)
    List<Bill> getBillsBetweenDates(Integer userId, Date fromDate, Date toDate);
    //endregion
}
