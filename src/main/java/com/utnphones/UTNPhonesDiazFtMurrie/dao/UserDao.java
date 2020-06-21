package com.utnphones.UTNPhonesDiazFtMurrie.dao;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    //region Methods:
    public User findByUsernameAndUserpassword(String username,String password);

    public boolean existsByUsername(String username);

    @Query(value = "select * from users u inner join userTypes ut on (u.idUserType = ut.idUserType) where ut.description = 'Client' and u.deleted = 0 ", nativeQuery = true)
    public List<User> findClients();

    public boolean existsByDni(String dni);

    @Query(value = "select * from users u where u.idUser = ?1 ", nativeQuery = true)
    public User getById(Integer id);
    //endregion
}
