package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest
{
    private UserService service;
    @Mock
    private UserDao dao;

    @Before
    public void setUp() throws Exception
    {
        initMocks(this);
        service=new UserService(dao);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void addUserOK() throws ValidationException
    {
        User expected=new User(null,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(dao.existsByDni(expected.getDni())).thenReturn(false);
        Mockito.when(dao.existsByUsername(expected.getDni())).thenReturn(false);
        Mockito.when(dao.save(expected)).thenReturn(expected);
        User result=service.addUser(expected);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void addUserOKExistsByDni() throws ValidationException
    {
        User expected=new User(null,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(dao.existsByDni(expected.getDni())).thenReturn(false);
        Mockito.when(dao.existsByUsername(expected.getDni())).thenReturn(false);
        Mockito.when(dao.save(expected)).thenReturn(expected);
        User result=service.addUser(expected);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void login()
    {
    }

    @Test
    public void getUserById()
    {
    }

    @Test
    public void getClientById()
    {
    }

    @Test
    public void getAll()
    {
    }

    @Test
    public void getClients()
    {
    }

    @Test
    public void updateUser()
    {
    }

    @Test
    public void suspendUser()
    {
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