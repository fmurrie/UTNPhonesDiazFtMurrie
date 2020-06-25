package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.BillDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.CityDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.NoContentException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Bill;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class BillServiceTest
{
    private BillService service;
    @Mock
    private BillDao billDao;
    @Mock
    private UserDao userDao;

    @Before
    public void setUp() throws Exception
    {
        initMocks(this);
        service=new BillService(billDao,userDao);

    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getById()
    {
        Optional<Bill> expected=Optional.of(mock(Bill.class));
        Mockito.when(billDao.findById(expected.get().getIdBill())).thenReturn(expected);
        Optional<Bill> result=service.getById(expected.get().getIdBill());
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getBillsByUserOK() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        List<Bill> expectedListBill=new ArrayList<Bill>();
        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(!expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            if(expectedListBill.size() != 0)
            {
                Mockito.when(billDao.getBillsByUser(id)).thenReturn(expectedListBill);
                List<Bill> result = service.getBillsByUser(id);
                assertNotNull(result);
                assertEquals(expectedListBill, result);
            }
        }
    }

    @Test(expected = NoContentException.class)
    public void getBillsByUserNoContentException() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        List<Bill> expectedListBill=new ArrayList<Bill>();
        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(!expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            if(expectedListBill.size() == 0)
            {
                Mockito.when(billDao.getBillsByUser(id)).thenReturn(expectedListBill);
                List<Bill> result = service.getBillsByUser(id);
            }
        }
    }

    @Test(expected = UserNotExistException.class)
    public void getBillsByUserUserNotExistException() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        Mockito.when(userDao.existsById(id)).thenReturn(false);
        service.getBillsByUser(id);
    }

    @Test(expected = ValidationException.class)
    public void getBillsByUserValidationException() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Employee",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        List<Bill> expectedListBill=new ArrayList<Bill>();
        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            List<Bill> result=service.getBillsByUser(id);
        }
    }

    @Test
    public void getBillsBetweenDatesOK() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        List<Bill> expectedListBill=new ArrayList<Bill>();
        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(!expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            Mockito.when(billDao.getBillsBetweenDates(id,mock(Date.class),mock(Date.class))).thenReturn(expectedListBill);
            if(expectedListBill.size() != 0)
            {
                List<Bill> result=service.getBillsBetweenDates(id,mock(Date.class),mock(Date.class));
                assertNotNull(result);
                assertEquals(expectedListBill,result);
            }
        }
    }

    @Test(expected=NoContentException.class)
    public void getBillsBetweenDatesNoContentException() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        List<Bill> expectedListBill=new ArrayList<Bill>();
        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(!expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            Mockito.when(billDao.getBillsBetweenDates(id,mock(Date.class),mock(Date.class))).thenReturn(expectedListBill);
            if(expectedListBill.size() == 0)
            {
                List<Bill> result=service.getBillsBetweenDates(id,mock(Date.class),mock(Date.class));
            }
        }
    }

    @Test(expected = UserNotExistException.class)
    public void getBillsBetweenDatesUserNotExistException() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        Mockito.when(userDao.existsById(id)).thenReturn(false);
        service.getBillsBetweenDates(id,mock(Date.class),mock(Date.class));
    }

    @Test(expected = ValidationException.class)
    public void getBillsBetweenDatesValidationException() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Employee",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            service.getBillsBetweenDates(id,mock(Date.class),mock(Date.class));
        }
    }
}