package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserDao dao;
    // public UserService(@Qualifier("userDao"){}
    @Autowired
    public UserService (UserDao dao) {
        this.dao = dao;
    }

    public User addUser(User user) throws UserAlreadyExistsException {
        return dao.save(user);
    }

    public Optional<User> getUserById(Integer userId){
        return dao.findById(userId);
    }

    public List<User> getAll(){
        return dao.findAll();
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

   /* public void removeUser(User user) throws UserNotexistException {
        if(dao.findById(user.getIdUser()) != null )
            dao.delete(user);
        else
            throw new UserNotexistException();
    }

*/
}
