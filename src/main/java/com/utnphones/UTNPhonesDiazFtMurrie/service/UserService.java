package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CityDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UpdateException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    //region Properties:
    private final UserDao dao;
    private final CityDao cityDao;
    //endregion

    //region Constructors:
    @Autowired
    public UserService (UserDao dao, CityDao cityDao) {
        this.dao = dao;
        this.cityDao = cityDao;
    }
    //endregion

    //region Methods:
    public User addUser(User user) throws ValidationException, NoSuchAlgorithmException {
        if(dao.existsByDni(user.getDni()))
            throw new ValidationException("ERROR! The DNI already Exists");
        if(dao.existsByUsername(user.getUsername()))
            throw new ValidationException("Sorry! The username already Exists");
        if(!cityDao.existsById(user.getCity().getIdCity()))
            throw new ValidationException("ERROR! the city does not exists!");

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(user.getUserpassword().getBytes(StandardCharsets.UTF_8));

        String hex = DatatypeConverter.printHexBinary(hash);
        user.setUserpassword(hex);
        return dao.save(user);
    }

    public User login(String username, String password) throws UserNotExistException, NoSuchAlgorithmException {
        if(null != dao.findByUsernameAndUserpassword(username, password) )
           if(dao.findByUsernameAndUserpassword(username, password).getUserType().getDescription().equals("Employee"))
                return Optional.ofNullable(dao.findByUsernameAndUserpassword(username, password)).orElseThrow(() -> new UserNotExistException());
        //Hashing the password
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        String hex = DatatypeConverter.printHexBinary(hash);
        // the hashed password is assigned to the param password
        password =hex;
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
            Optional<User> user = dao.findById(id);
            if (user.get().getUserType().getDescription().equals("Client"))
                return user;
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

    public User updateUser(Integer idUser, UserUpdateRequestDto updatedUser) throws UserNotExistException, ValidationException, UpdateException {
        User user = dao.findById(idUser).get();
        if(user != null){
            if(user.getUserType().getDescription().equals("Employee"))
                throw new UpdateException("Sorry! You are not allowed to update this user");
            if(!(updatedUser.getDni().equals(user.getDni()))){
                if (dao.existsByDni(updatedUser.getDni()))
                    throw new ValidationException("ERROR! The DNI already exists!");
            }
            if(!cityDao.existsById(updatedUser.getCity().getIdCity()))
                throw new ValidationException("SORRY! The city do not exists!");

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

    public User suspendUser(Integer idUser) throws UserNotExistException, UpdateException {
        User user = dao.findById(idUser).get();
        if(user != null){
            if(user.getUserType().getDescription().equals("Employee"))
                throw new UpdateException("Sorry! You are not allowed to suspend this user");
            user.setSuspended(true);
            return dao.save(user);
        }
        else
            throw new UserNotExistException();
    }

    public User enableUser(Integer idUser) throws UserNotExistException, UpdateException {
        User user = dao.findById(idUser).get();
        if(user != null){
            if(user.getUserType().getDescription().equals("Employee"))
                throw new UpdateException("Sorry! You are not allowed to enable this user");
            user.setSuspended(false);
            return dao.save(user);
        }
        else
            throw new UserNotExistException();
    }

    public User deleteUser(Integer idUser) throws UserNotExistException, UpdateException {
        User user = dao.findById(idUser).get();
        if(user != null){
            if(user.getUserType().getDescription().equals("Employee"))
                throw new UpdateException("Sorry! You are not allowed to delete this user");
            user.setDeleted(true);
            return dao.save(user);
        }
        else
            throw new UserNotExistException();
    }
    //endregion
}
