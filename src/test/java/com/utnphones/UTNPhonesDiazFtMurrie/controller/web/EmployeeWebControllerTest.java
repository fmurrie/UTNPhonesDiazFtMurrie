package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.*;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
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

public class EmployeeWebControllerTest
{
    private EmployeeWebController controller;
    @Mock
    private SessionManager sessionManager;
    @Mock
    private UserController userController;
    @Mock
    private AdviceController adviceController;
    @Mock
    private UserTypeController userTypeController;
    @Mock
    private PhoneLineController phoneLineController;
    @Mock
    private RateController rateController;
    @Mock
    private CallController callController;
    @Mock
    private BillController billController;

    @Before
    public void setUp() throws Exception
    {
        initMocks(this);
        controller=new EmployeeWebController(sessionManager,userController,adviceController,userTypeController,phoneLineController,rateController,callController,billController);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void addClientOK() throws ValidationException, NoSuchAlgorithmException
    {
        String token="token";
        UserType expectedUserType=new UserType(null,"Client",null);
        User expectedUser=new User(null,expectedUserType,"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(userTypeController.getUserTypeById(expectedUser.getUserType().getIdUserType())).thenReturn(Optional.of(expectedUserType));
        if(expectedUserType.getDescription().equals("Client"))
        {
            controller.addClient(token,expectedUser);
        }
    }

    @Test
    public void addClientAddUserException() throws ValidationException, NoSuchAlgorithmException
    {
        String token="token";
        UserType expectedUserType=new UserType(null,"Employee",null);
        User expectedUser=new User(null,expectedUserType,"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(userTypeController.getUserTypeById(expectedUser.getUserType().getIdUserType())).thenReturn(Optional.of(expectedUserType));
        if(!expectedUserType.getDescription().equals("Client"))
        {
            controller.addClient(token,expectedUser);
        }
    }

    @Test
    public void addClientUserTypeNotExists() throws ValidationException, NoSuchAlgorithmException
    {

    }

    @Test
    public void getCurrentUser() throws UserNotExistException
    {
        Integer id=10;
        String token="token";
        UserType expectedUserType=new UserType(null,"Employee",null);
        User expectedUser=new User(id,expectedUserType,"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(sessionManager.getCurrentUser(token)).thenReturn(expectedUser);
        Mockito.when(userController.getUserById(id)).thenReturn(expectedUser);
        controller.getCurrentUser(token);
    }

    @Test
    public void getClients()
    {
        String token="token";
        List<User> expectedClients=new ArrayList<User>();
        Mockito.when(userController.getClients()).thenReturn(expectedClients);
        controller.getClients(token);
    }

    @Test
    public void getClient() throws UserNotExistException, ValidationException
    {
        Integer id=10;
        String token="token";
        UserType expectedUserType=new UserType(null,"Employee",null);
        User expectedUser=new User(id,expectedUserType,"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(userController.getClientById(id)).thenReturn(expectedUser);
        controller.getClient(token,id);
    }

    @Test
    public void updateClient()
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

    @Test
    public void addPhoneLine()
    {
    }

    @Test
    public void getPhoneLine()
    {
    }

    @Test
    public void getPhoneLines()
    {
    }

    @Test
    public void suspendPhoneLine()
    {
    }

    @Test
    public void enablePhoneLine()
    {
    }

    @Test
    public void deletePhoneLine()
    {
    }

    @Test
    public void getAllRates()
    {
    }

    @Test
    public void testGetPhoneLine()
    {
    }

    @Test
    public void getUserCalls()
    {
    }

    @Test
    public void getBills()
    {
    }

    @Test
    public void getBillsBetweenDates()
    {
    }
}