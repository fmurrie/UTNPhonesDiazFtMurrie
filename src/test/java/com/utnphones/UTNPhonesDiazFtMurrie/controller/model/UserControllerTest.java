package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import com.utnphones.UTNPhonesDiazFtMurrie.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserControllerTest
{
    private UserController controller;
    @Mock
    private UserService service;

    @Before
    public void setUp() throws Exception
    {
        initMocks(this);
        controller=new UserController(service);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void addUser() throws ValidationException
    {
        User expected=mock(User.class);
        Mockito.when(service.addUser(expected)).thenReturn(expected);
        User result= controller.addUser(expected);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getUsers()
    {
        Mockito.when(service.getAll()).thenReturn(new ArrayList<User>());
        List<User> result= controller.getUsers();
        assertNotNull(result);
    }

    @Test
    public void getUserById() throws UserNotExistException
    {
        Integer id=10;
        Optional<User> expected=Optional.of(new User(id,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Mockito.when(service.getUserById(id)).thenReturn(expected);
        User result=controller.getUserById(id);
        assertNotNull(result);
    }

    @Test
    public void getClients()
    {
        Mockito.when(service.getClients()).thenReturn(new ArrayList<User>());
        List<User> result= controller.getClients();
        assertNotNull(result);
    }

    @Test
    public void getClientById() throws UserNotExistException, ValidationException
    {
        Integer id=10;
        Optional<User> expected=Optional.of(new User(id,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Mockito.when(service.getClientById(id)).thenReturn(expected);
        User result=controller.getClientById(id);
        assertNotNull(result);
    }

    @Test
    public void loginOK() throws UserNotExistException, ValidationException
    {
        String username="username";
        String password="password";
        User expected=new User(10,mock(UserType.class),"dni","nombre","apellido",mock(City.class),username,password,false,false,null);
        if ((username != null) && (password != null))
        {
            Mockito.when(service.login(username, password)).thenReturn(expected);
            User result=controller.login(username, password);
            assertNotNull(result);
        }
    }
    @Test(expected = ValidationException.class)
    public void loginValidationException() throws UserNotExistException, ValidationException
    {
        String username=null;
        String password=null;
        if ((username == null) && (password == null))
        {
            Mockito.when(controller.login(username, password)).thenThrow(new ValidationException("username and password must have a value"));
            User result=controller.login(username, password);;
        }
    }

    @Test
    public void updateUser() throws UserNotExistException, ValidationException
    {
        Integer id=10;
        UserUpdateRequestDto updatedUser=mock(UserUpdateRequestDto.class);
        User expected=new User(id,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(service.updateUser(id, updatedUser)).thenReturn(expected);
        User result=controller.updateUser(id, updatedUser);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void suspendUser() throws UserNotExistException
    {
        Integer id=10;
        User expected=new User(id,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(service.suspendUser(id)).thenReturn(expected);
        User result=controller.suspendUser(id);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void enableUser() throws UserNotExistException
    {
        Integer id=10;
        User expected=new User(id,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(service.enableUser(id)).thenReturn(expected);
        User result=controller.enableUser(id);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void deleteUser() throws UserNotExistException
    {
        Integer id=10;
        User expected=new User(id,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(service.deleteUser(id)).thenReturn(expected);
        User result=controller.deleteUser(id);
        assertNotNull(result);
        assertEquals(expected,result);
    }
}