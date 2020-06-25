package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CallDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.PhoneLineDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.NoContentException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.*;
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

public class CallServiceTest
{
    private CallService service;
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
        service = new CallService(callDao,userDao,phoneLineDao);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void addCallOK() throws PhoneLineException, Exception {
        Integer idOrigin = 1;
        Integer idDestiny =2;
        Optional<PhoneLine> origin =Optional.of(new PhoneLine(idOrigin,mock(LineType.class),"1234",mock(User.class),false,false,null));
        Optional<PhoneLine> destiny =Optional.of(new PhoneLine(idDestiny,mock(LineType.class),"4567",mock(User.class),false,false,null));

        Call expected=new Call(null,mock(CallType.class),mock(Bill.class),origin.get(),destiny.get(),mock(Date.class),mock(Date.class),null,null);

        Mockito.when(phoneLineDao.findById(idOrigin)).thenReturn(origin);
        Mockito.when(phoneLineDao.findById(idDestiny)).thenReturn(destiny);
        Mockito.when(phoneLineDao.existsById(idOrigin)).thenReturn(true);
        Mockito.when(phoneLineDao.existsById(idDestiny)).thenReturn(true);

        if(!(origin.get().isDeleted() && origin.get().isSuspended() && destiny.get().isDeleted() && destiny.get().isSuspended()))
        {
            Mockito.when(callDao.save(expected)).thenReturn(expected);
            Call result=service.addCall(expected);
            assertNotNull(result);
            assertEquals(expected,result);
        }
    }

    @Test(expected = PhoneLineException.class)
    public void addCallOriginNotExists() throws PhoneLineException, Exception {
        Integer idOrigin = 1;
        Integer idDestiny =2;
        Optional<PhoneLine> origin =Optional.of(new PhoneLine(idOrigin,mock(LineType.class),"1234",mock(User.class),false,false,null));
        Optional<PhoneLine> destiny =Optional.of(new PhoneLine(idDestiny,mock(LineType.class),"4567",mock(User.class),false,false,null));

        Call expected=new Call(null,mock(CallType.class),mock(Bill.class),origin.get(),destiny.get(),mock(Date.class),mock(Date.class),null,null);

        Mockito.when(phoneLineDao.findById(idOrigin)).thenReturn(origin);
        Mockito.when(phoneLineDao.findById(idDestiny)).thenReturn(destiny);
        Mockito.when(phoneLineDao.existsById(idOrigin)).thenReturn(false);
        Call result=service.addCall(expected);
    }

    @Test(expected = PhoneLineException.class)
    public void addCallDestinyNotExists() throws PhoneLineException, Exception {
        Integer idOrigin = 1;
        Integer idDestiny =2;
        Optional<PhoneLine> origin =Optional.of(new PhoneLine(idOrigin,mock(LineType.class),"1234",mock(User.class),false,false,null));
        Optional<PhoneLine> destiny =Optional.of(new PhoneLine(idDestiny,mock(LineType.class),"4567",mock(User.class),false,false,null));

        Call expected=new Call(null,mock(CallType.class),mock(Bill.class),origin.get(),destiny.get(),mock(Date.class),mock(Date.class),null,null);

        Mockito.when(phoneLineDao.findById(idOrigin)).thenReturn(origin);
        Mockito.when(phoneLineDao.findById(idDestiny)).thenReturn(destiny);
        Mockito.when(phoneLineDao.existsById(idOrigin)).thenReturn(true);
        Mockito.when(phoneLineDao.existsById(idDestiny)).thenReturn(false);
        Call result=service.addCall(expected);
    }

    @Test(expected = PhoneLineException.class)
    public void addCallOriginDeletedOrSuspended() throws PhoneLineException, Exception {
        Integer idOrigin = 1;
        Integer idDestiny =2;
        Optional<PhoneLine> origin =Optional.of(new PhoneLine(idOrigin,mock(LineType.class),"1234",mock(User.class),true,true,null));
        Optional<PhoneLine> destiny =Optional.of(new PhoneLine(idDestiny,mock(LineType.class),"4567",mock(User.class),false,false,null));

        Call expected=new Call(null,mock(CallType.class),mock(Bill.class),origin.get(),destiny.get(),mock(Date.class),mock(Date.class),null,null);

        Mockito.when(phoneLineDao.findById(idOrigin)).thenReturn(origin);
        Mockito.when(phoneLineDao.findById(idDestiny)).thenReturn(destiny);
        Mockito.when(phoneLineDao.existsById(idOrigin)).thenReturn(true);
        Mockito.when(phoneLineDao.existsById(idDestiny)).thenReturn(true);

        if(origin.get().isDeleted() && origin.get().isSuspended())
        {
            Call result=service.addCall(expected);
        }
    }

    @Test(expected = PhoneLineException.class)
    public void addCallDestinyDeletedOrSuspended() throws PhoneLineException, Exception {
        Integer idOrigin = 1;
        Integer idDestiny =2;
        Optional<PhoneLine> origin =Optional.of(new PhoneLine(idOrigin,mock(LineType.class),"1234",mock(User.class),false,false,null));
        Optional<PhoneLine> destiny =Optional.of(new PhoneLine(idDestiny,mock(LineType.class),"4567",mock(User.class),true,true,null));

        Call expected=new Call(null,mock(CallType.class),mock(Bill.class),origin.get(),destiny.get(),mock(Date.class),mock(Date.class),null,null);

        Mockito.when(phoneLineDao.findById(idOrigin)).thenReturn(origin);
        Mockito.when(phoneLineDao.findById(idDestiny)).thenReturn(destiny);
        Mockito.when(phoneLineDao.existsById(idOrigin)).thenReturn(true);
        Mockito.when(phoneLineDao.existsById(idDestiny)).thenReturn(true);

        if(destiny.get().isDeleted() && destiny.get().isSuspended())
        {
            Call result=service.addCall(expected);
        }
    }

    @Test
    public void getCallsByUserOK() throws UserNotExistException, ValidationException
    {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        List<Call> expectedListCall=new ArrayList<Call>();
        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(!expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            Mockito.when(callDao.getCallsByUser(id)).thenReturn(expectedListCall);
            List<Call> result=service.getCallsByUser(id);
            assertNotNull(result);
            assertEquals(expectedListCall,result);
        }
    }

    @Test(expected = UserNotExistException.class)
    public void getCallsByUserUserNotExistException() throws UserNotExistException, ValidationException
    {
        Integer id=1;
        Mockito.when(userDao.existsById(id)).thenReturn(false);
        service.getCallsByUser(id);
    }

    @Test(expected = ValidationException.class)
    public void getCallsByUserValidationException() throws UserNotExistException, ValidationException
    {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Employee",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        List<Call> expectedListCall=new ArrayList<Call>();
        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            List<Call> result=service.getCallsByUser(id);
        }
    }

    @Test
    public void getCallById() throws ValidationException, UserNotExistException
    {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));

        Integer idOrigin = 1;
        Integer idDestiny =2;
        Optional<PhoneLine> origin =Optional.of(new PhoneLine(idOrigin,mock(LineType.class),"1234",mock(User.class),false,false,null));
        Optional<PhoneLine> destiny =Optional.of(new PhoneLine(idDestiny,mock(LineType.class),"4567",mock(User.class),true,true,null));
        Optional<Call> expected=Optional.of(new Call(id,mock(CallType.class),mock(Bill.class),origin.get(),destiny.get(),mock(Date.class),mock(Date.class),null,null));

        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        Mockito.when(callDao.findById(id)).thenReturn(expected);

        if(!expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            Optional<Call> result=service.getCallById(id);
            assertNotNull(result);
            assertEquals(expected,result);
        }
    }

    @Test(expected = ValidationException.class)
    public void getCallByIdValidationException() throws ValidationException, UserNotExistException
    {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Employee",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));

        Integer idOrigin = 1;
        Integer idDestiny =2;
        Optional<PhoneLine> origin =Optional.of(new PhoneLine(idOrigin,mock(LineType.class),"1234",mock(User.class),false,false,null));
        Optional<PhoneLine> destiny =Optional.of(new PhoneLine(idDestiny,mock(LineType.class),"4567",mock(User.class),true,true,null));
        Optional<Call> expected=Optional.of(new Call(id,mock(CallType.class),mock(Bill.class),origin.get(),destiny.get(),mock(Date.class),mock(Date.class),null,null));

        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        Mockito.when(callDao.findById(id)).thenReturn(expected);

        if(expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            service.getCallById(id);
        }
    }

    @Test(expected = UserNotExistException.class)
    public void getCallByIdUserNotExistException() throws ValidationException, UserNotExistException
    {
        Integer id=1;
        Mockito.when(userDao.existsById(id)).thenReturn(false);
        service.getCallById(id);
    }

    @Test
    public void getCallsBetweenDatesOK() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Client",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        List<Call> expectedListCall=new ArrayList<Call>();
        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(!expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            if(expectedListCall.size() != 0)
            {
                Mockito.when(callDao.getCallsBetweenDates(id, mock(Date.class), mock(Date.class))).thenReturn(expectedListCall);
                List<Call> result = service.getCallsBetweenDates(id, mock(Date.class), mock(Date.class));
                assertNotNull(result);
                assertEquals(expectedListCall, result);
            }
        }
    }

    @Test(expected = UserNotExistException.class)
    public void getCallsBetweenDatesUserNotExistException() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        Mockito.when(userDao.existsById(id)).thenReturn(false);
        service.getCallsBetweenDates(id,mock(Date.class),mock(Date.class));
    }

    @Test(expected = ValidationException.class)
    public void getCallsBetweenDatesValidationException() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        Optional<User> expectedUser=Optional.of(new User(id,new UserType(null,"Employee",null),"dni","nombre","apellido",mock(City.class),"username","password",false,false,null));
        Mockito.when(userDao.existsById(id)).thenReturn(true);
        Mockito.when(userDao.findById(id)).thenReturn(expectedUser);
        if(expectedUser.get().getUserType().getDescription().equals("Employee"))
        {
            service.getCallsBetweenDates(id,mock(Date.class),mock(Date.class));
        }
    }
}