package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.LineTypeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.PhoneLineDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.LineAndCallsQuantityDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.*;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class PhoneLineServiceTest
{
    private PhoneLineService service;
    @Mock
    private PhoneLineDao phoneLineDao;
    @Mock
    private UserDao userDao;
    @Mock
    private LineTypeDao linetypeDao;

    @Before
    public void setUp() throws Exception
    {
        initMocks(this);
        service=new PhoneLineService(phoneLineDao,userDao,linetypeDao);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void addPhoneLineOK() throws UserNotExistException, LineTypeNotExistsException, ValidationException
    {
        PhoneLine expected=new PhoneLine(null,mock(LineType.class),"1234",mock(User.class),false,false,null);
        Mockito.when(linetypeDao.existsById(expected.getLineType().getIdLineType())).thenReturn(true);
        Mockito.when(userDao.existsById(expected.getUser().getIdUser())).thenReturn(true);
        Optional<User> expected2=Optional.of(new User(expected.getUser().getIdUser(),new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Mockito.when(userDao.findById(expected.getUser().getIdUser())).thenReturn(expected2);
        if(!expected2.get().getUserType().getDescription().equals("Employee"))
        {
            Mockito.when(phoneLineDao.save(expected)).thenReturn(expected);
            PhoneLine result=service.addPhoneLine(expected);
            assertNotNull(result);
            assertEquals(expected,result);
        }
    }

    @Test(expected = ValidationException.class)
    public void addPhoneLineValidationException() throws UserNotExistException, LineTypeNotExistsException, ValidationException
    {
        PhoneLine expected=new PhoneLine(null,mock(LineType.class),"1234",mock(User.class),false,false,null);
        Mockito.when(linetypeDao.existsById(expected.getLineType().getIdLineType())).thenReturn(true);
        Mockito.when(userDao.existsById(expected.getUser().getIdUser())).thenReturn(true);
        Optional<User> expected2=Optional.of(new User(expected.getUser().getIdUser(),new UserType(null,"Employee",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Mockito.when(userDao.findById(expected.getUser().getIdUser())).thenReturn(expected2);
        if(expected2.get().getUserType().getDescription().equals("Employee"))
        {
            PhoneLine result=service.addPhoneLine(expected);
        }
    }

    @Test(expected = LineTypeNotExistsException.class)
    public void addPhoneLineFAILLineTypeNotExistsException() throws UserNotExistException, LineTypeNotExistsException, ValidationException
    {
        PhoneLine expected=new PhoneLine(null,mock(LineType.class),"1234",mock(User.class),false,false,null);
        Mockito.when(linetypeDao.existsById(expected.getLineType().getIdLineType())).thenReturn(false);
        Mockito.when(userDao.existsById(expected.getUser().getIdUser())).thenReturn(true);
        Mockito.when(service.addPhoneLine(expected)).thenThrow(new UserNotExistException());
        service.addPhoneLine(expected);
    }

    @Test(expected = UserNotExistException.class)
    public void addPhoneLineFAILUserNotExistException() throws UserNotExistException, LineTypeNotExistsException, ValidationException
    {
        PhoneLine expected=new PhoneLine(null,mock(LineType.class),"1234",mock(User.class),false,false,null);
        Mockito.when(linetypeDao.existsById(expected.getLineType().getIdLineType())).thenReturn(true);
        Mockito.when(userDao.existsById(expected.getUser().getIdUser())).thenReturn(false);
        Mockito.when(service.addPhoneLine(expected)).thenThrow(new UserNotExistException());
        service.addPhoneLine(expected);
    }

    @Test
    public void getAllOK() throws PhoneLineException
    {
        List<PhoneLine> expected= new ArrayList<PhoneLine>();
        Mockito.when(phoneLineDao.findAll()).thenReturn(expected);
        if(expected.size() != 0)
        {
            List<PhoneLine> result= service.getAll();
            assertNotNull(result);
            assertEquals(expected,result);
        }
    }

    @Test(expected = PhoneLineException.class)
    public void getAllPhoneLineException() throws PhoneLineException
    {
        List<PhoneLine> expected= new ArrayList<PhoneLine>();
        Mockito.when(phoneLineDao.findAll()).thenReturn(expected);
        if(expected.size() == 0)
        {
            List<PhoneLine> result= service.getAll();
        }
    }

    @Test
    public void getPhoneLineOK() throws ValidationException, PhoneLineException
    {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"NoClient",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Optional<PhoneLine> expectedPline=Optional.of(new PhoneLine(id,mock(LineType.class),"1234",expectedUser.get(),false,false,null));
        Mockito.when(phoneLineDao.existsById(id)).thenReturn(true);
        Mockito.when(phoneLineDao.findById(id)).thenReturn(expectedPline);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(!expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            Optional<PhoneLine> result=service.getPhoneLine(id);
            assertNotNull(result);
            assertEquals(expectedPline,result);
        }
    }

    @Test(expected = ValidationException.class)
    public void getPhoneLineValidationException() throws ValidationException, PhoneLineException
    {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Employee",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Optional<PhoneLine> expectedPline=Optional.of(new PhoneLine(id,mock(LineType.class),"1234",expectedUser.get(),false,false,null));
        Mockito.when(phoneLineDao.existsById(id)).thenReturn(true);
        Mockito.when(phoneLineDao.findById(id)).thenReturn(expectedPline);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            Optional<PhoneLine> result=service.getPhoneLine(id);
        }
    }

    @Test(expected = PhoneLineException.class)
    public void getPhoneLinePhoneLineException() throws ValidationException, PhoneLineException
    {
        Integer id=1;
        Mockito.when(phoneLineDao.existsById(id)).thenReturn(false);
        Optional<PhoneLine> result=service.getPhoneLine(id);
    }

    @Test
    public void suspendPhoneLineOK() throws ValidationException, PhoneLineException
    {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Optional<PhoneLine> expectedPline=Optional.of(new PhoneLine(id,mock(LineType.class),"1234",expectedUser.get(),false,false,null));
        Mockito.when(phoneLineDao.findById(id)).thenReturn(expectedPline);
        Mockito.when(phoneLineDao.save(expectedPline.get())).thenReturn(expectedPline.get());
        PhoneLine result=service.suspendPhoneLine(id);
        assertNotNull(result);
    }

    @Test
    public void enablePhoneLineOK() throws ValidationException, PhoneLineException
    {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Optional<PhoneLine> expectedPline=Optional.of(new PhoneLine(id,mock(LineType.class),"1234",expectedUser.get(),false,false,null));
        Mockito.when(phoneLineDao.findById(id)).thenReturn(expectedPline);
        Mockito.when(phoneLineDao.save(expectedPline.get())).thenReturn(expectedPline.get());
        PhoneLine result=service.enablePhoneLine(id);
        assertNotNull(result);
    }

    @Test
    public void deletePhoneLineOK() throws ValidationException, PhoneLineException
    {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Optional<PhoneLine> expectedPline=Optional.of(new PhoneLine(id,mock(LineType.class),"1234",expectedUser.get(),false,false,null));
        Mockito.when(phoneLineDao.findById(id)).thenReturn(expectedPline);
        Mockito.when(phoneLineDao.save(expectedPline.get())).thenReturn(expectedPline.get());
        PhoneLine result=service.deletePhoneLine(id);
        assertNotNull(result);
    }

    @Test
    public void top10Destinies() throws UserNotExistException, ValidationException {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Optional<PhoneLine> expectedPline=Optional.of(new PhoneLine(id,mock(LineType.class),"1234",expectedUser.get(),false,false,null));
        List<LineAndCallsQuantityDto> expectedlist = new ArrayList<>();
        List<PhoneLine> listPlExpected=new ArrayList<PhoneLine>();

        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(!expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            Mockito.when(phoneLineDao.top10Destinies(id)).thenReturn(listPlExpected);
            List<LineAndCallsQuantityDto> result=service.top10Destinies(id);
            assertNotNull(result);
            assertEquals(expectedlist,result);
        }
    }
}