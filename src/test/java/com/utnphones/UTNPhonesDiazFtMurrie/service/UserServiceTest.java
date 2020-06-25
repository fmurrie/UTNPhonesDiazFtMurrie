package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CityDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UpdateException;
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

import static java.util.Objects.isNull;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
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
    public void addUserOK() throws ValidationException, NoSuchAlgorithmException {
    }

    @Test(expected = ValidationException.class)
    public void addUserExistsByDni() throws ValidationException, NoSuchAlgorithmException {
        User expected=new User(null,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        when(dao.existsByDni(expected.getDni())).thenReturn(true);
        when(dao.existsByUsername(expected.getUsername())).thenReturn(false);
        when(service.addUser(expected)).thenThrow(new ValidationException("ERROR! The DNI already Exists"));
        User result=service.addUser(expected);
    }

    @Test(expected = ValidationException.class)
    public void addUserExistsByUsername() throws ValidationException, NoSuchAlgorithmException {
        User expected=new User(null,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        when(dao.existsByDni(expected.getDni())).thenReturn(false);
        when(dao.existsByUsername(expected.getUsername())).thenReturn(true);
        when(service.addUser(expected)).thenThrow(new ValidationException("Sorry! The username already Exists"));
        User result=service.addUser(expected);
    }

    @Test(expected = ValidationException.class)
    public void addUserExistsByCity() throws ValidationException, NoSuchAlgorithmException {
        User expected=new User(null,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        when(dao.existsByDni(expected.getDni())).thenReturn(false);
        when(dao.existsByUsername(expected.getUsername())).thenReturn(true);
        when(service.addUser(expected)).thenThrow(new ValidationException("Sorry! The username already Exists"));
        User result=service.addUser(expected);
    }

    @Test
    public void loginOK() throws UserNotExistException, NoSuchAlgorithmException {
    }

    @Test(expected = UserNotExistException.class)
    public void loginUserNotExistException() throws UserNotExistException, NoSuchAlgorithmException {
        String username="username";
        String password="password";
        when(service.login(username,password)).thenThrow(new UserNotExistException());
        User result=service.login(username,password);
    }

    @Test
    public void getUserByIdOK() throws UserNotExistException
    {
        Integer id=1;
        Optional<User> expected=Optional.of(new User(id,mock(UserType.class),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        when(dao.existsById(id)).thenReturn(true);
        when(dao.findById(id)).thenReturn(expected);
        Optional<User> result=service.getUserById(id);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test(expected = UserNotExistException.class)
    public void getUserByIdUserNotExistException() throws UserNotExistException
    {
        Integer id=1;
        when(dao.existsById(id)).thenReturn(false);
        when(service.getUserById(id)).thenThrow(new UserNotExistException());
        Optional<User> result=service.getUserById(id);
    }

    @Test
    public void getClientByIdOK() throws UserNotExistException, ValidationException
    {
        Integer id=10;
        Optional<User> expected=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        when(dao.existsById(id)).thenReturn(true);
        when(dao.findById(id)).thenReturn(expected);
        if (expected.get().getUserType().getDescription().equals("Client"))
        {
            Optional<User> result=service.getClientById(id);
            assertNotNull(result);
            assertEquals(expected,result);
        }
    }

    @Test(expected = ValidationException.class)
    public void getClientByIdValidationException() throws UserNotExistException, ValidationException
    {
        Integer id=10;
        Optional<User> expected=Optional.of(new User(id,new UserType(null,"NoClient",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        when(dao.existsById(id)).thenReturn(true);
        when(dao.findById(id)).thenReturn(expected);
        if (!expected.get().getUserType().getDescription().equals("Client"))
        {
            Optional<User> result=service.getClientById(id);
        }
    }

    @Test(expected = UserNotExistException.class)
    public void getClientByIdUserNotExistException() throws UserNotExistException, ValidationException
    {
        Integer id=10;
        when(dao.existsById(id)).thenReturn(false);
        Optional<User> result=service.getClientById(id);
    }

    @Test()
    public void getAll()
    {
        when(dao.findAll()).thenReturn(new ArrayList<User>());
        List<User> result= service.getAll();
        assertNotNull(result);
    }

    @Test
    public void getClients()
    {
        when(dao.findClients()).thenReturn(new ArrayList<User>());
        List<User> result= service.getClients();
        assertNotNull(result);
    }

    /*@Test
    public void updateUserOK() throws UserNotExistException, ValidationException, UpdateException {
        Integer id=1;
        Optional<User> expected=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        UserUpdateRequestDto updatedUser=mock(UserUpdateRequestDto.class);

        when(dao.findById(id)).thenReturn(expected);
        when(dao.existsByDni(expected.get().getDni())).thenReturn(false);
        when(dao.save(expected.get())).thenReturn(expected.get());

        if(!expected.get().getUserType().getDescription().equals("Employee"))
        {
            if(!(updatedUser.getDni().equals(expected.get().getDni())))
            {
                if (!dao.existsByDni(expected.get().getDni()))
                {
                    User result=service.updateUser(id,new UserUpdateRequestDto("dni","nombre","apellido",mock(City.class),"username","password"));
                    assertNotNull(result);
                }
            }
        }

    }*/


    @Test
    public void suspendUserOK() throws UserNotExistException, UpdateException {
        Integer id=1;
        Optional<User> expected=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        when(dao.findById(id)).thenReturn(expected);
        when(dao.save(expected.get())).thenReturn(expected.get());
        if(!expected.get().getUserType().getDescription().equals("Employee"))
        {
            User result = service.suspendUser(id);
            assertNotNull(result);
        }
    }

    @Test
    public void enableUserOK() throws UserNotExistException, UpdateException {
        Integer id=1;
        Optional<User> expected=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        when(dao.findById(id)).thenReturn(expected);
        when(dao.save(expected.get())).thenReturn(expected.get());
        if(!expected.get().getUserType().getDescription().equals("Employee"))
        {
            User result=service.enableUser(id);
            assertNotNull(result);
        }
    }

    @Test
    public void deleteUserOK() throws UserNotExistException, UpdateException {
        Integer id=1;
        Optional<User> expected=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        when(dao.findById(id)).thenReturn(expected);
        when(dao.save(expected.get())).thenReturn(expected.get());
        if(!expected.get().getUserType().getDescription().equals("Employee"))
        {
            User result = service.deleteUser(id);
            assertNotNull(result);
        }
    }

    @Test(expected = UpdateException.class)
    public void updateExceptionFAIL() throws UserNotExistException, UpdateException
    {
        Integer id=1;
        Optional<User> expected=Optional.of(new User(id,new UserType(null,"Employee",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        when(dao.findById(id)).thenReturn(expected);
        when(dao.save(expected.get())).thenReturn(expected.get());
        if(expected.get().getUserType().getDescription().equals("Employee"))
        {
            User result = service.deleteUser(id);
        }
    }
}