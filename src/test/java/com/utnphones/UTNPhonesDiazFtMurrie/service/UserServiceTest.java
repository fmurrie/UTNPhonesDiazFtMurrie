package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CityDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest
{
    private UserService service;
    @Mock
    private UserDao dao;

    @Mock
    private CityDao cityDao;

    @Before
    public void setUp() throws Exception
    {
        initMocks(this);
        service=new UserService(dao,cityDao);
    }

    @After
    public void tearDown() throws Exception
    {
    }

   @Test
    public void addUserOK() throws ValidationException  {
        User expected=new User(null,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(dao.existsByDni(expected.getDni())).thenReturn(false);
        Mockito.when(dao.existsByUsername(expected.getDni())).thenReturn(false);
        Mockito.when(dao.save(expected)).thenReturn(expected);
        User result=service.addUser(expected);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test(expected = ValidationException.class)
    public void addUserExistsByDni() throws ValidationException  {
        User expected=new User(null,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(dao.existsByDni(expected.getDni())).thenReturn(true);
        Mockito.when(dao.existsByUsername(expected.getUsername())).thenReturn(false);
        Mockito.when(service.addUser(expected)).thenThrow(new ValidationException("ERROR! The DNI already Exists"));
        User result=service.addUser(expected);
    }

    @Test(expected = ValidationException.class)
    public void addUserExistsByUsername() throws ValidationException{
        User expected=new User(null,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(dao.existsByDni(expected.getDni())).thenReturn(false);
        Mockito.when(dao.existsByUsername(expected.getUsername())).thenReturn(true);
        Mockito.when(service.addUser(expected)).thenThrow(new ValidationException("Sorry! The username already Exists"));
        User result=service.addUser(expected);
    }

    @Test(expected = ValidationException.class)
    public void addUserExistsByCity() throws ValidationException{
        User expected=new User(null,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(dao.existsByDni(expected.getDni())).thenReturn(false);
        Mockito.when(dao.existsByUsername(expected.getUsername())).thenReturn(true);
        Mockito.when(service.addUser(expected)).thenThrow(new ValidationException("Sorry! The username already Exists"));
        User result=service.addUser(expected);
    }

    @Test
    public void loginOK() throws UserNotExistException
    {
        String username="username";
        String password="password";
        User expected=new User(null,mock(UserType.class),"dni","nombre","apellido",mock(City.class),username,password,false,false,null);
        Mockito.when(dao.findByUsernameAndUserpassword(username,password)).thenReturn(expected);
        User result=service.login(username,password);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test(expected = UserNotExistException.class)
    public void loginUserNotExistException() throws UserNotExistException
    {
        String username="username";
        String password="password";
        Mockito.when(service.login(username,password)).thenThrow(new UserNotExistException());
        User result=service.login(username,password);
    }

    @Test
    public void getUserByIdOK() throws UserNotExistException
    {
        Integer id=1;
        Optional<User> expected=Optional.of(new User(id,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Mockito.when(dao.existsById(id)).thenReturn(true);
        Mockito.when(dao.findById(id)).thenReturn(expected);
        Optional<User> result=service.getUserById(id);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test(expected = UserNotExistException.class)
    public void getUserByIdUserNotExistException() throws UserNotExistException
    {
        Integer id=1;
        Mockito.when(dao.existsById(id)).thenReturn(false);
        Mockito.when(service.getUserById(id)).thenThrow(new UserNotExistException());
        Optional<User> result=service.getUserById(id);
    }

    @Test
    public void getClientById()
    {
    }

    @Test()
    public void getAll()
    {
        Mockito.when(dao.findAll()).thenReturn(new ArrayList<User>());
        List<User> result= service.getAll();
        assertNotNull(result);
    }

    @Test
    public void getClients()
    {
        Mockito.when(dao.findClients()).thenReturn(new ArrayList<User>());
        List<User> result= service.getAll();
        assertNotNull(result);
    }

    @Test
    public void updateUserOK() throws UserNotExistException, ValidationException
    {
        Integer id=1;
        Optional<User> expected=Optional.of(new User(id,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Mockito.when(dao.findById(id)).thenReturn(expected);
        Mockito.when(dao.save(expected.get())).thenReturn(expected.get());
        User result=service.updateUser(id,new UserUpdateRequestDto("dni","nombre","apellido",mock(City.class),"username","password"));
        assertNotNull(result);
    }

    @Test(expected = UserNotExistException.class)
    public void updateUserUserNotExistException() throws UserNotExistException, ValidationException
    {
        Integer id=1;
        Mockito.when(dao.findById(id)).thenReturn(null);
        Mockito.when(service.updateUser(id,new UserUpdateRequestDto("dni","nombre","apellido",mock(City.class),"username","password"))).thenThrow(new UserNotExistException());
        User result=service.updateUser(id,new UserUpdateRequestDto("dni","nombre","apellido",mock(City.class),"username","password"));
    }

    @Test
    public void suspendUserOK() throws UserNotExistException
    {
        Integer id=1;
        Optional<User> expected=Optional.of(new User(id,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Mockito.when(dao.findById(id)).thenReturn(expected);
        Mockito.when(dao.save(expected.get())).thenReturn(expected.get());
        User result=service.suspendUser(id);
        assertNotNull(result);
    }

    @Test(expected = UserNotExistException.class)
    public void suspendUserUserNotExistException() throws UserNotExistException
    {
        Integer id=1;
        Mockito.when(dao.findById(id)).thenReturn(null);
        User result=service.suspendUser(id);
    }

    @Test
    public void enableUser()
    {
    }

    @Test
    public void deleteUser()
    {
    }
}