package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CallDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.PhoneLineDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class CallServiceTest
{
    CallService callService;
    @Mock
    private CallDao callDao;

    @Mock
    private UserDao userDao;

    @Mock
    private PhoneLineDao phoneLineDao;

    @Before
    public void setUp() throws Exception
    {
        initMocks(this);
        callService = new CallService(callDao,userDao,phoneLineDao);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void addCallOK() throws PhoneLineException {
        Call expected = new Call(null, mock(CallType.class), mock(Bill.class) , mock(PhoneLine.class),
                mock(PhoneLine.class), null, null,  null , null);

        Mockito.when(phoneLineDao.existsById(expected.getPhoneLineOrigin().getIdPhoneLine())).thenReturn(true);
        Mockito.when(phoneLineDao.existsById(expected.getPhoneLineDestiny().getIdPhoneLine())).thenReturn(true);
        Mockito.when(callDao.save(expected)).thenReturn(expected);

        Call result = callService.addCall(expected);
        assertNotNull(result);
        assertEquals(expected,result);
    }
    /*PhoneLine expected=new PhoneLine(null,mock(LineType.class),"1234",mock(User.class),false,false,null);
        Mockito.when(linetypeDao.existsById(expected.getLineType().getIdLineType())).thenReturn(true);
        Mockito.when(userDao.existsById(expected.getUser().getIdUser())).thenReturn(true);
        Mockito.when(phoneLineDao.save(expected)).thenReturn(expected);
    PhoneLine result=service.addPhoneLine(expected);
    assertNotNull(result);
    assertEquals(expected,result);*/

    @Test
    public void getCallsByUser()
    {
        /*List<Call> expected = new ArrayList<>();
        Mockito.when(callDao.existsById(expected.get().getIdLineType())).thenReturn(true);
        Mockito.when(phoneLineDao.save(expected)).thenReturn(expected);*/
    }

    @Test
    public void getCallById()
    {
    }

    @Test
    public void getCallsBetweenDates()
    {
    }
}