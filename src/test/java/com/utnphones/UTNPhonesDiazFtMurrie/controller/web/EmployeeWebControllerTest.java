package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.*;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UpdateException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.*;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
    public void getCurrentUserUserNotExistsException() throws UserNotExistException
    {
        Integer id=10;
        String token="token";
        UserType expectedUserType=new UserType(null,"Employee",null);
        User expectedUser=new User(id,expectedUserType,"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(sessionManager.getCurrentUser(token)).thenReturn(expectedUser);
        Mockito.when(userController.getUserById(id)).thenThrow(new UserNotExistException());
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
    public void getClientUserNotExistsException() throws UserNotExistException, ValidationException
    {
        Integer id=10;
        String token="token";
        UserType expectedUserType=new UserType(null,"Employee",null);
        User expectedUser=new User(id,expectedUserType,"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(userController.getClientById(id)).thenThrow(new UserNotExistException());
        controller.getClient(token,id);
    }

    @Test
    public void getClientUserValidationException() throws UserNotExistException, ValidationException
    {
        Integer id=10;
        String token="token";
        UserType expectedUserType=new UserType(null,"Employee",null);
        User expectedUser=new User(id,expectedUserType,"dni","nombre","apellido",mock(City.class),"username","password",false,false,null);
        Mockito.when(userController.getClientById(id)).thenThrow(new ValidationException("alo"));
        controller.getClient(token,id);
    }

    @Test
    public void updateUserOk() throws ValidationException, UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        UserUpdateRequestDto userUpdateRequestDto = mock(UserUpdateRequestDto.class);
        User user = mock(User.class);
        when(userController.updateUser(id,userUpdateRequestDto)).thenReturn(user);

        ResponseEntity expected = ResponseEntity.ok(userController.updateUser(id, userUpdateRequestDto));
        ResponseEntity result = controller.updateClient(token,id,userUpdateRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);

    }

    @Test
    public void updateUserValidationException() throws ValidationException, UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        UserUpdateRequestDto userUpdateRequestDto = mock(UserUpdateRequestDto.class);
        User user = mock(User.class);
        when(userController.updateUser(id,userUpdateRequestDto)).thenThrow(new ValidationException("aloja"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleValidationException(new ValidationException("aloja")));
        ResponseEntity result = controller.updateClient(token,id,userUpdateRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void updateUserUserNotExistsException() throws ValidationException, UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        UserUpdateRequestDto userUpdateRequestDto = mock(UserUpdateRequestDto.class);
        User user = mock(User.class);
        when(userController.updateUser(id,userUpdateRequestDto)).thenThrow(new UserNotExistException());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists( new UserNotExistException()));
        ResponseEntity result = controller.updateClient(token,id,userUpdateRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void updateUserUpdateException() throws ValidationException, UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        UserUpdateRequestDto userUpdateRequestDto = mock(UserUpdateRequestDto.class);
        User user = mock(User.class);
        when(userController.updateUser(id,userUpdateRequestDto)).thenThrow(new UpdateException("aloja"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleUpdateException(new UpdateException("aloja")));
        ResponseEntity result = controller.updateClient(token,id,userUpdateRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void suspendUserOk() throws UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        User user = mock(User.class);
        when(userController.suspendUser(id)).thenReturn(user);

        ResponseEntity expected = ResponseEntity.ok(userController.suspendUser(id));
        ResponseEntity result = controller.suspendUser(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void suspendUserUserNotExistsException() throws UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        User user = mock(User.class);
        when(userController.suspendUser(id)).thenThrow(new UserNotExistException());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(new UserNotExistException()));
        ResponseEntity result = controller.suspendUser(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void suspendUserUpdateException() throws UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        User user = mock(User.class);
        when(userController.suspendUser(id)).thenThrow(new UpdateException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleUpdateException(new UpdateException("alo")));
        ResponseEntity result = controller.suspendUser(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void enableUser() throws UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        User user = mock(User.class);
        when(userController.enableUser(id)).thenReturn(user);

        ResponseEntity expected = ResponseEntity.ok(userController.enableUser(id));
        ResponseEntity result = controller.enableUser(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void enableUserUserNotExists() throws UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        User user = mock(User.class);
        when(userController.enableUser(id)).thenThrow(new UserNotExistException());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(new UserNotExistException()));
        ResponseEntity result = controller.enableUser(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void enableUserUpdateException() throws UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        User user = mock(User.class);
        when(userController.enableUser(id)).thenThrow(new UpdateException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleUpdateException(new UpdateException("alo")));
        ResponseEntity result = controller.enableUser(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void deleteUserOk() throws UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        User user = mock(User.class);
        when(userController.deleteUser(id)).thenReturn(user);

        ResponseEntity expected = ResponseEntity.ok(userController.deleteUser(id));
        ResponseEntity result = controller.deleteUser(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void deleteUserUserNotExistsException() throws UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        User user = mock(User.class);
        when(userController.deleteUser(id)).thenThrow(new UserNotExistException());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(new UserNotExistException()));
        ResponseEntity result = controller.deleteUser(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void deleteUserUpdateException() throws UserNotExistException, UpdateException {
        String token = "holaSoyElToken";
        Integer id = 1;
        User user = mock(User.class);
        when(userController.deleteUser(id)).thenThrow(new UpdateException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleUpdateException(new UpdateException("alo")));
        ResponseEntity result = controller.deleteUser(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void addPhoneLine()
    {
    }

    @Test
    public void getPhoneLineOk() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.getPhoneLine(id)).thenReturn(phoneLine);

        ResponseEntity expected = ResponseEntity.ok(phoneLineController.getPhoneLine(id));
        ResponseEntity result = controller.getPhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getPhoneLinePhoneLineException() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.getPhoneLine(id)).thenThrow(new PhoneLineException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handlePhoneLineException(new PhoneLineException("alo")));
        ResponseEntity result = controller.getPhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getPhoneLineValidationException() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.getPhoneLine(id)).thenThrow(new ValidationException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(new ValidationException("alo")));
        ResponseEntity result = controller.getPhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getPhoneLines() throws PhoneLineException {
        String token = "holaSoyElToken";
        List<PhoneLine> phoneLines = mock(List.class);
        when(phoneLineController.getAllPhoneLines()).thenReturn(phoneLines);

        ResponseEntity expected = ResponseEntity.ok(phoneLineController.getAllPhoneLines());
        ResponseEntity result = controller.getPhoneLines(token);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getPhoneLinesPhoneLineException() throws PhoneLineException {
        String token = "holaSoyElToken";
        List<PhoneLine> phoneLines = mock(List.class);
        when(phoneLineController.getAllPhoneLines()).thenThrow(new PhoneLineException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.NO_CONTENT).body(adviceController.handlePhoneLineException(new PhoneLineException("alo")));
        ResponseEntity result = controller.getPhoneLines(token);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void suspendPhoneLineOk() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.suspendPhoneLine(id)).thenReturn(phoneLine);

        ResponseEntity expected = ResponseEntity.ok(phoneLineController.suspendPhoneLine(id));
        ResponseEntity result = controller.suspendPhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void suspendPhoneLinePhoneLineException() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.suspendPhoneLine(id)).thenThrow(new PhoneLineException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handlePhoneLineException(new PhoneLineException("alo")));
        ResponseEntity result = controller.suspendPhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void suspendPhoneLineValidationException() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.suspendPhoneLine(id)).thenThrow(new ValidationException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(new ValidationException("alo")));
        ResponseEntity result = controller.suspendPhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void enablePhoneLineOk() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.enablePhoneLine(id)).thenReturn(phoneLine);

        ResponseEntity expected = ResponseEntity.ok(phoneLineController.enablePhoneLine(id));
        ResponseEntity result = controller.enablePhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void enablePhoneLinePhoneLineException() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.enablePhoneLine(id)).thenThrow(new PhoneLineException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handlePhoneLineException(new PhoneLineException("alo")));
        ResponseEntity result = controller.enablePhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }


    @Test
    public void enablePhoneLineValidationException() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.enablePhoneLine(id)).thenThrow(new ValidationException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(new ValidationException("alo")));
        ResponseEntity result = controller.enablePhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void deletePhoneLineOk() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.deletePhoneLine(id)).thenReturn(phoneLine);

        ResponseEntity expected = ResponseEntity.ok(phoneLineController.deletePhoneLine(id));
        ResponseEntity result = controller.deletePhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void deletePhoneLinePhoneLineException() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.deletePhoneLine(id)).thenThrow(new PhoneLineException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handlePhoneLineException(new PhoneLineException("alo")));
        ResponseEntity result = controller.deletePhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }


    @Test
    public void deletePhoneLineValidationException() throws ValidationException, PhoneLineException {
        String token = "holaSoyElToken";
        Integer id = 1;
        PhoneLine phoneLine = mock(PhoneLine.class);
        when(phoneLineController.deletePhoneLine(id)).thenThrow(new ValidationException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(new ValidationException("alo")));
        ResponseEntity result = controller.deletePhoneLine(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }
    @Test
    public void getAllRates()
    {
        String token = "holaSoyElToken";
        List<Rate> rates = mock(List.class);
        when(rateController.getAllRates()).thenReturn(rates);

        ResponseEntity expected = ResponseEntity.ok(rateController.getAllRates());
        ResponseEntity result = controller.getAllRates(token);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void testGetRateById()
    {
        String token = "holaSoyElToken";
        Integer id1 = 1;
        Integer id2 = 2;
        Rate rate = mock(Rate.class);
        when(rateController.getRateById(1,2)).thenReturn(Optional.ofNullable(rate));

        ResponseEntity expected = ResponseEntity.ok(rateController.getRateById(1,2));
        ResponseEntity result = controller.getRateById(token,id1,id2);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getUserCalls() throws UserNotExistException, ValidationException {
        String token = "holaSoyElToken";
        Integer id = 1;
        List<Call> callList = mock(List.class);
        when(callController.getCallsByUser(id)).thenReturn(callList);

        ResponseEntity expected = ResponseEntity.ok(callController.getCallsByUser(id));
        ResponseEntity result = controller.getUserCalls(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getUserCallsUserNotExistsException() throws UserNotExistException, ValidationException {
        String token = "holaSoyElToken";
        Integer id = 1;
        List<Call> callList = mock(List.class);
        when(callController.getCallsByUser(id)).thenThrow(new UserNotExistException());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(new UserNotExistException()));
        ResponseEntity result = controller.getUserCalls(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getUserCallsValidationException() throws UserNotExistException, ValidationException {
        String token = "holaSoyElToken";
        Integer id = 1;
        List<Call> callList = mock(List.class);
        when(callController.getCallsByUser(id)).thenThrow(new ValidationException("alo"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(new ValidationException("alo")));
        ResponseEntity result = controller.getUserCalls(token,id);

        assertNotNull(result);
        assertEquals(expected,result);
    }

}