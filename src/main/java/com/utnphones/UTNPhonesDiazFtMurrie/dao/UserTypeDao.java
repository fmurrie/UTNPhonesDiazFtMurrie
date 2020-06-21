package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTypeDao extends JpaRepository <UserType,Integer> {
    //region Methods:
    List<UserType> findByDescription(String description);

    @Query(value = "select * from userTypes ut where ut.idUserType = ?1", nativeQuery = true)
    UserType getById(Integer id);
    //endregion
}
