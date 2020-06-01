package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.projection.UserCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    //Methods:
    public User findByUsernameAndUserpassword(String username,String password);
    public List<User> findByFirstName(String username);

    @Query(value = "SELECT u.dni,count(*) as callsCount FROM users u inner join phoneLines p on p.idUser=u.idUser inner join calls c on c.idPhoneLineOrigin=p.idPhoneLine group by u.dni",nativeQuery = true)
    List<UserCall> getUserCall();
}
