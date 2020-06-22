package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.LineTypeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.PhoneLineDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.LineTypeNotExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.LineType;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

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
        Mockito.when(phoneLineDao.save(expected)).thenReturn(expected);
        PhoneLine result=service.addPhoneLine(expected);
        assertNotNull(result);
        assertEquals(expected,result);
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
    public void getAll()
    {
    }

    @Test
    public void getPhoneLine()
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
    public void top10Destinataries()
    {
    }
}