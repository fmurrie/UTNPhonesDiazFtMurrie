package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.BillController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.CallController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.PhoneLineController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.GetBetweenDatesRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.LineAndCallsQuantityDto;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.NoContentException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Bill;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.session.Session;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Validation;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientWebControllerTest {

    private ClientWebController clientWebController;
    private  SessionManager sessionManager;
    private  UserController userController;
    private  PhoneLineController phoneLineController;
    private  CallController callController;
    private  BillController billController;
    private  AdviceController adviceController;

    @Before
    public void setUp() throws Exception {
         sessionManager = mock(SessionManager.class);
         userController = mock(UserController.class);
         phoneLineController = mock(PhoneLineController.class);
         callController = mock(CallController.class);
         billController = mock(BillController.class);
         adviceController = mock(AdviceController.class);

         clientWebController = new ClientWebController(sessionManager,userController,phoneLineController,
                 callController,billController,adviceController);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCurrentUserOk() throws UserNotExistException {

        String token = "holaSoyElToken";
        User user = mock(User.class);
        Integer id = user.getIdUser();
        when(user.getIdUser()).thenReturn(id);
        Mockito.when(sessionManager.getCurrentUser(token)).thenReturn(user);
        Mockito.when(userController.getUserById(id)).thenReturn(user);

        ResponseEntity expected = ResponseEntity.ok(userController.getUserById(id));
        ResponseEntity result = clientWebController.getCurrentUser(token);

        assertNotNull(result);
        assertEquals(expected,result);

    }
    @Test
    public void getCurrentUserUserNotExistException() throws UserNotExistException {

        String token = "holaSoyElToken";
        User user = mock(User.class);
        Integer id = user.getIdUser();
        when(user.getIdUser()).thenReturn(id);
        Mockito.when(sessionManager.getCurrentUser(token)).thenReturn(user);
        Mockito.when(userController.getUserById(id)).thenThrow(new UserNotExistException());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.NOT_FOUND).body(adviceController.handleUserNotExists(new UserNotExistException()));
        ResponseEntity result = clientWebController.getCurrentUser(token);

        assertNotNull(result);
        assertEquals(expected,result);

    }

    @Test
    public void updateUserOk() throws ValidationException, UserNotExistException {
        String token = "holaSoyElToken";
        UserUpdateRequestDto userUpdateRequestDto = mock(UserUpdateRequestDto.class);
        User user = mock(User.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(userController.updateUser(sessionManager.getCurrentUser(token).getIdUser(),userUpdateRequestDto)).thenReturn(user);

        ResponseEntity expected = ResponseEntity.ok(userController.updateUser(sessionManager.getCurrentUser(token).getIdUser(), userUpdateRequestDto));
        ResponseEntity result = clientWebController.updateUser(token,userUpdateRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);

    }

    @Test
    public void updateUserValidationException() throws ValidationException, UserNotExistException {
        String token = "holaSoyElToken";
        UserUpdateRequestDto userUpdateRequestDto = mock(UserUpdateRequestDto.class);
        User user = mock(User.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(userController.updateUser(sessionManager.getCurrentUser(token).getIdUser(),userUpdateRequestDto)).thenThrow(new ValidationException("ERROR! The DNI already exists!"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleValidationException(new ValidationException("ERROR! The DNI already exists!")));
        ResponseEntity result = clientWebController.updateUser(token,userUpdateRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);

    }

    @Test
    public void updateUserUserNotExistException() throws ValidationException, UserNotExistException {
        String token = "holaSoyElToken";
        UserUpdateRequestDto userUpdateRequestDto = mock(UserUpdateRequestDto.class);
        User user = mock(User.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(userController.updateUser(sessionManager.getCurrentUser(token).getIdUser(),userUpdateRequestDto)).thenThrow(new UserNotExistException());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(new UserNotExistException()));
        ResponseEntity result = clientWebController.updateUser(token,userUpdateRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void top10UserDestiniesOk() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<LineAndCallsQuantityDto> lineAndCallsQuantityDtos = mock(List.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(phoneLineController.top10Destinies(sessionManager.getCurrentUser(token).getIdUser())).thenReturn(lineAndCallsQuantityDtos);

        ResponseEntity expected = ResponseEntity.ok(phoneLineController.top10Destinies(sessionManager.getCurrentUser(token).getIdUser()));
        ResponseEntity result =  clientWebController.top10UserDestinies(token);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void top10UserDestiniesUserNotExistException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<LineAndCallsQuantityDto> lineAndCallsQuantityDtos = mock(List.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(phoneLineController.top10Destinies(sessionManager.getCurrentUser(token).getIdUser())).thenThrow(new UserNotExistException());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(new UserNotExistException()));
        ResponseEntity result =  clientWebController.top10UserDestinies(token);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void top10UserDestiniesValidationException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<LineAndCallsQuantityDto> lineAndCallsQuantityDtos = mock(List.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(phoneLineController.top10Destinies(sessionManager.getCurrentUser(token).getIdUser())).thenThrow(new ValidationException("aloja"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(new ValidationException("aloja")));
        ResponseEntity result =  clientWebController.top10UserDestinies(token);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void top10UserDestiniesNoContentException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<LineAndCallsQuantityDto> lineAndCallsQuantityDtos = mock(List.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(phoneLineController.top10Destinies(sessionManager.getCurrentUser(token).getIdUser())).thenThrow(new NoContentException("aloja"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.NO_CONTENT).body(adviceController.handleNoContentException(new NoContentException("aloja")));
        ResponseEntity result =  clientWebController.top10UserDestinies(token);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getCallsOk() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Call> calls = mock(List.class);
        GetBetweenDatesRequestDto getBetweenDatesRequestDto = mock(GetBetweenDatesRequestDto.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(callController.getCallsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(), getBetweenDatesRequestDto.getInitDate(), getBetweenDatesRequestDto.getEndDate())).thenReturn(calls);

        ResponseEntity expected = ResponseEntity.ok(callController.getCallsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(), getBetweenDatesRequestDto.getInitDate(), getBetweenDatesRequestDto.getEndDate()));
        ResponseEntity result = clientWebController.getCalls(token,getBetweenDatesRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getCallsUserNotExistException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Call> calls = mock(List.class);
        GetBetweenDatesRequestDto getBetweenDatesRequestDto = mock(GetBetweenDatesRequestDto.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(callController.getCallsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(), getBetweenDatesRequestDto.getInitDate(), getBetweenDatesRequestDto.getEndDate())).thenThrow(new UserNotExistException());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(new UserNotExistException()));
        ResponseEntity result = clientWebController.getCalls(token,getBetweenDatesRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getCallsValidationException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Call> calls = mock(List.class);
        GetBetweenDatesRequestDto getBetweenDatesRequestDto = mock(GetBetweenDatesRequestDto.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(callController.getCallsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(), getBetweenDatesRequestDto.getInitDate(), getBetweenDatesRequestDto.getEndDate())).thenThrow(new ValidationException("aloja"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(new ValidationException("aloja")));
        ResponseEntity result = clientWebController.getCalls(token,getBetweenDatesRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getCallsNoContentException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Call> calls = mock(List.class);
        GetBetweenDatesRequestDto getBetweenDatesRequestDto = mock(GetBetweenDatesRequestDto.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(callController.getCallsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(), getBetweenDatesRequestDto.getInitDate(), getBetweenDatesRequestDto.getEndDate())).thenThrow(new NoContentException("aloja"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.NO_CONTENT).body(adviceController.handleNoContentException(new NoContentException("aloja")));
        ResponseEntity result = clientWebController.getCalls(token,getBetweenDatesRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getBillsOk() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Bill> calls = mock(List.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(billController.getBillsByUser(sessionManager.getCurrentUser(token).getIdUser())).thenReturn(calls);

        ResponseEntity expected =  ResponseEntity.ok(billController.getBillsByUser(sessionManager.getCurrentUser(token).getIdUser()));
        ResponseEntity result = clientWebController.getBills(token);

        assertNotNull(result);
        assertEquals(expected,result);

    }

    @Test
    public void getBillsUserNotExistsException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Bill> calls = mock(List.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(billController.getBillsByUser(sessionManager.getCurrentUser(token).getIdUser())).thenThrow(new UserNotExistException());

        ResponseEntity expected =  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(new UserNotExistException()));
        ResponseEntity result = clientWebController.getBills(token);

        assertNotNull(result);
        assertEquals(expected,result);

    }

    @Test
    public void getBillsValidationException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Bill> calls = mock(List.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(billController.getBillsByUser(sessionManager.getCurrentUser(token).getIdUser())).thenThrow(new ValidationException("aloja"));

        ResponseEntity expected =  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(new ValidationException("aloja")));
        ResponseEntity result = clientWebController.getBills(token);

        assertNotNull(result);
        assertEquals(expected,result);

    }

    @Test
    public void getBillsNoContentException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Bill> calls = mock(List.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(billController.getBillsByUser(sessionManager.getCurrentUser(token).getIdUser())).thenThrow(new NoContentException("aloja"));

        ResponseEntity expected =  ResponseEntity.status(HttpStatus.NO_CONTENT).body(adviceController.handleNoContentException(new NoContentException("aloja")));
        ResponseEntity result = clientWebController.getBills(token);

        assertNotNull(result);
        assertEquals(expected,result);

    }

    @Test
    public void getBillsBetweenDatesOk() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Bill> calls = mock(List.class);
        GetBetweenDatesRequestDto getBetweenDatesRequestDto = mock(GetBetweenDatesRequestDto.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(billController.getBillsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(),getBetweenDatesRequestDto.getInitDate(),getBetweenDatesRequestDto.getEndDate())).thenReturn(calls);

        ResponseEntity expected = ResponseEntity.ok(billController.getBillsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(),getBetweenDatesRequestDto.getInitDate(),getBetweenDatesRequestDto.getEndDate()));
        ResponseEntity result = clientWebController.getBillsBetweenDates(token,getBetweenDatesRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getBillsBetweenDatesUserNotExistsException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Bill> calls = mock(List.class);
        GetBetweenDatesRequestDto getBetweenDatesRequestDto = mock(GetBetweenDatesRequestDto.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(billController.getBillsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(),getBetweenDatesRequestDto.getInitDate(),getBetweenDatesRequestDto.getEndDate())).thenThrow(new UserNotExistException());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(new UserNotExistException()));
        ResponseEntity result = clientWebController.getBillsBetweenDates(token,getBetweenDatesRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getBillsBetweenDatesValidationException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Bill> calls = mock(List.class);
        GetBetweenDatesRequestDto getBetweenDatesRequestDto = mock(GetBetweenDatesRequestDto.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(billController.getBillsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(),getBetweenDatesRequestDto.getInitDate(),getBetweenDatesRequestDto.getEndDate())).thenThrow(new ValidationException("aloja"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(new ValidationException("aloja")));
        ResponseEntity result = clientWebController.getBillsBetweenDates(token,getBetweenDatesRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getBillsBetweenDatesNoContentException() throws UserNotExistException, ValidationException, NoContentException {
        String token = "holaSoyElToken";
        User user = mock(User.class);
        List<Bill> calls = mock(List.class);
        GetBetweenDatesRequestDto getBetweenDatesRequestDto = mock(GetBetweenDatesRequestDto.class);
        when(sessionManager.getCurrentUser(token)).thenReturn(user);
        when(billController.getBillsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(),getBetweenDatesRequestDto.getInitDate(),getBetweenDatesRequestDto.getEndDate())).thenThrow(new NoContentException("aloja"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.NO_CONTENT).body(adviceController.handleNoContentException(new NoContentException("aloja")));
        ResponseEntity result = clientWebController.getBillsBetweenDates(token,getBetweenDatesRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }
}