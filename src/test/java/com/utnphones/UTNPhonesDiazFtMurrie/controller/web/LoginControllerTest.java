package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.LoginRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.InvalidLoginException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoginControllerTest {

    MockMvc mockMvc;
    LoginController loginController;
    UserController userController;
    SessionManager sessionManager;
    AdviceController adviceController;

    @Before
    public void setUp() throws Exception {
        userController = mock(UserController.class);
        sessionManager = mock(SessionManager.class);
        adviceController = mock(AdviceController.class);
        loginController = new LoginController(userController,sessionManager,adviceController);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loginOk() throws ValidationException, InvalidLoginException, UserNotExistException, NoSuchAlgorithmException {
        LoginRequestDto loginRequestDto = mock(LoginRequestDto.class);
        User user = mock(User.class);
        Mockito.when(userController.login(loginRequestDto.getUsername(), loginRequestDto.getUserpassword())).thenReturn(user);
        String token = "requiredToken";
        Mockito.when(sessionManager.createSession(user)).thenReturn("requiredToken");

        ResponseEntity expected = ResponseEntity.ok().headers(loginController.createHeaders(token)).build();
        ResponseEntity result = loginController.login(loginRequestDto);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test(expected = InvalidLoginException.class)
    public void loginInvalidLoginException() throws ValidationException, InvalidLoginException, NoSuchAlgorithmException
    {
         try{
             LoginRequestDto loginRequestDto = mock(LoginRequestDto.class);
             User user = mock(User.class);
             Mockito.when(userController.login(loginRequestDto.getUsername(), loginRequestDto.getUserpassword())).thenThrow(new UserNotExistException());
             String token = "requiredToken";
             Mockito.when(sessionManager.createSession(user)).thenReturn("requiredToken");

             ResponseEntity expected = loginController.login(loginRequestDto);
             ResponseEntity result = loginController.login(loginRequestDto);

             assertNotNull(result);
             assertEquals(expected,result);
         }
         catch(UserNotExistException exc)
         {
             throw new InvalidLoginException(exc);
         }
    }

    @Test
    public void loginNoSuchAlgorithmException() throws ValidationException, InvalidLoginException, UserNotExistException
    {
        try{
            LoginRequestDto loginRequestDto = mock(LoginRequestDto.class);
            User user = mock(User.class);
            Mockito.when(userController.login(loginRequestDto.getUsername(), loginRequestDto.getUserpassword())).thenThrow(new NoSuchAlgorithmException());
            String token = "requiredToken";
            Mockito.when(sessionManager.createSession(user)).thenReturn("requiredToken");

            ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleValidationException(new ValidationException("An error as occurred with the password!")));
            ResponseEntity result = loginController.login(loginRequestDto);

            assertNotNull(result);
            assertEquals(expected,result);
        }
        catch(NoSuchAlgorithmException exc){

        }

    }

    @Test(expected = ValidationException.class)
    public void loginValidationException() throws ValidationException, InvalidLoginException, UserNotExistException, ValidationException, NoSuchAlgorithmException {
        LoginRequestDto loginRequestDto = mock(LoginRequestDto.class);
        User user = mock(User.class);
        Mockito.when(userController.login(loginRequestDto.getUsername(), loginRequestDto.getUserpassword())).thenThrow(new ValidationException("username and password must have a value"));
        String token = "requiredToken";
        Mockito.when(sessionManager.createSession(user)).thenReturn("requiredToken");

        ResponseEntity expected = loginController.login(loginRequestDto);
        ResponseEntity result = loginController.login(loginRequestDto);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void logoutOk() throws Exception {
        String token = "soyElToken";
        ResponseEntity expected = ResponseEntity.ok().build();
        ResponseEntity result = loginController.logout(token);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void createHeadersOk() throws Exception {
        String token = "validCode";
        HttpHeaders expected = new HttpHeaders();
        expected.set("Authorization", token);
        HttpHeaders result = new HttpHeaders();
        result = loginController.createHeaders(token);

        assertNotNull(result);
        assertEquals(expected,result);
        }
}