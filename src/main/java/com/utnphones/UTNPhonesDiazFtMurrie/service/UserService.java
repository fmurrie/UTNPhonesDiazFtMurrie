package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import com.utnphones.UTNPhonesDiazFtMurrie.projection.UserCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Optional<User> getUserById(Integer id)
    {
        return dao.findById(id);
    }


    public User login(String username, String password) throws UserNotexistException {
        User user = dao.findByUsernameAndUserpassword(username, password);
        return Optional.ofNullable(user).orElseThrow(() -> new UserNotexistException());
    }

    public User updateUser(User updatedUser) throws UserNotexistException {
        if(dao.existsById(updatedUser.getIdUser())){
            dao.deleteById(updatedUser.getIdUser());
            return dao.save(updatedUser);
        }
        else throw new UserNotexistException();
    }

   /* public List<UserCall> getCallsCountByDni(String dni)
    {
        return dao.getUserCall(dni);
    }*/

    /////////////////////////////////////////////////PARCIAL/////////////////////////////////////////////////
    /////////////////////////////////////////////////PARCIAL/////////////////////////////////////////////////
    /////////////////////////////////////////////////PARCIAL/////////////////////////////////////////////////

    public List<User> getUsersByDni(String dni){
        List<User> list = new ArrayList<>();
        if(dni == "par")
            list =dao.getUsersByDniPar();
        else if (dni == "impar")
            list= dao.getUsersByDniImpar();

        return list;
    }









   /* public void removeUser(User user) throws UserNotexistException {
        if(dao.findById(user.getIdUser()) != null )
            dao.delete(user);
        else
            throw new UserNotexistException();
    }

*/
}
