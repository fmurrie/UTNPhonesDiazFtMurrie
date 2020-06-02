package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.LineAndCallsQuantityDto;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneLineDao extends JpaRepository<PhoneLine, Integer> {

    @Query(value = "select * from phoneLines dp inner join calls c on dp.idPhoneLine = c.idPhoneLineDestiny" +
            " inner join phoneLines op on op.idPhoneLine = c.idPhoneLineOrigin where op.idUser = ?1 " +
            " group by c.idPhoneLineDestiny order by count(c.idPhoneLineDestiny) DESC limit 3", nativeQuery = true)
    List<PhoneLine> top3Destinataries(Integer userId);

    @Query(value = "select count(c.idCall) from phoneLines dp inner join calls c on dp.idPhoneLine = c.idPhoneLineDestiny" +
            " inner join phoneLines op on op.idPhoneLine = c.idPhoneLineOrigin where op.idUser = ?1" +
            " and dp.idPhoneLine =?2", nativeQuery = true)
    Integer callsQuantity(Integer idUser, Integer idPhoneLine);

    @Query(value = "select * from phonelines p where phoneNumber like '%) 221-%'",nativeQuery = true)
    List<PhoneLine> getByAreaCode221();
}
