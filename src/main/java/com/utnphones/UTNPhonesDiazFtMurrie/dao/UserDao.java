package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer>
{
    //region Methods:
    User findByUsernameAndUserpassword(String username,String password);

    boolean existsByUsername(String username);

    @Query(value = "select * from users u inner join userTypes ut on (u.idUserType = ut.idUserType) where ut.description = 'Client' and u.deleted = 0 ", nativeQuery = true)
    List<User> findClients();

    boolean existsByDni(String dni);
    //endregion
}
