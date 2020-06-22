package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    //region Properties:
    private final UserDao dao;
    //endregion

    //region Constructors:
    @Autowired
    public UserService (UserDao dao) {
        this.dao = dao;
    }
    //endregion

    //region Methods:
    public User addUser(User user) throws ValidationException {

        if(dao.existsByDni(user.getDni()))
            throw new ValidationException("ERROR! The DNI already Exists");
        else if(dao.existsByUsername(user.getUsername()))
            throw new ValidationException("Sorry! The username already Exists");
        else
            return dao.save(user);

    }

    public User login(String username, String password) throws UserNotExistException {
        User user = dao.findByUsernameAndUserpassword(username, password);
        return Optional.ofNullable(user).orElseThrow(() -> new UserNotExistException());
    }

    public Optional<User> getUserById(Integer id) throws UserNotExistException {
        if(dao.existsById(id))
            return dao.findById(id);
        else
            throw new UserNotExistException();
    }

    public Optional<User> getClientById(Integer id) throws UserNotExistException, ValidationException {
        if(dao.existsById(id)) {
            User user = dao.findById(id).get();
            if (user.getUserType().getDescription().equals("Client"))
                return dao.findById(id);
            else
                throw new ValidationException("Sorry! you are not allowed to see this user!");
        }
        else
            throw new UserNotExistException();
    }

    public List<User> getAll()
    {
        return dao.findAll();
    }

    public List<User> getClients() {
            return dao.findClients();
    }

    public User updateUser(Integer idUser, UserUpdateRequestDto updatedUser) throws UserNotExistException, ValidationException {
        User user = dao.findById(idUser).get();
        if(user != null){
            if(!(updatedUser.getDni().equals(user.getDni()))){
                if (dao.existsByDni(updatedUser.getDni()))
                    throw new ValidationException("ERROR! The DNI already exists!");
            }
            if(!updatedUser.getUsername().equals(user.getUsername())) {
                if (dao.existsByUsername(updatedUser.getUsername()))
                    throw new ValidationException("SORRY! The username already exists!");
            }
            user.setDni(updatedUser.getDni());
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setCity(updatedUser.getCity());
            user.setUsername(updatedUser.getUsername());
            user.setUserpassword(updatedUser.getUserpassword());

            return dao.save(user);
        }
        else
            throw new UserNotExistException();
    }

    public User suspendUser(Integer idUser) throws UserNotExistException {
        User user = dao.findById(idUser).get();
        if(user != null){
            user.setSuspended(true);
            return dao.save(user);
        }
        else
            throw new UserNotExistException();
    }

    public User enableUser(Integer idUser) throws UserNotExistException {
        User user = dao.findById(idUser).get();
        if(user != null){
            user.setSuspended(false);
            return dao.save(user);
        }
        else
            throw new UserNotExistException();
    }

    public User deleteUser(Integer idUser) throws UserNotExistException {
        User user = dao.findById(idUser).get();
        if(user != null){
            user.setDeleted(true);
            return dao.save(user);
        }
        else
            throw new UserNotExistException();
    }
    //endregion
}
