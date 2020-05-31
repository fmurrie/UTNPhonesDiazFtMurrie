package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    //Properties:
    private final UserDao dao;

    //Constructors:
    @Autowired
    public UserService (UserDao dao) {
        this.dao = dao;
    }

    public User addUser(User user) throws UserAlreadyExistsException { return dao.save(user); }

    //Methods:
    public List<User> getAll()
    {
        return dao.findAll();
    }

    public Optional<User> getById(Integer id)
    {
        return dao.findById(id);
    }



   /* public void removeUser(User user) throws UserNotexistException {
        if(dao.findById(user.getIdUser()) != null )
            dao.delete(user);
        else
            throw new UserNotexistException();
    }
    public User updateUser(User user) throws UserNotexistException {
        if (dao.delete(user);) {
            return user;
        } else
            throw new UserNotexistException();
    }
    public User login(String username, String password) throws UserNotexistException {
        User user = dao.findByUsername(username, password);
        return Optional.ofNullable(user).orElseThrow(() -> new UserNotexistException());
    }*/
}
