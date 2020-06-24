package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.exception.DniNotExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.NoContentException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.*;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CountryService;
import com.utnphones.UTNPhonesDiazFtMurrie.service.UserService;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserControllerTest {

    UserController controller;
    UserService service;

    @BeforeEach
    void setUp() {

        service = mock(UserService.class);
        controller = new UserController(service);

    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getUsersByDniOk() throws DniNotExistsException, NoContentException {
        String dni = "par";

        List<User> userlist = mock(List.class);
        Mockito.when(service.getUsersByDni(dni)).thenReturn(userlist);

        ResponseEntity expected = ResponseEntity.ok(service.getUsersByDni(dni));
        ResponseEntity result = controller.getUsersByDni(dni);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getUsersByDniDniNotExistsException() throws DniNotExistsException, NoContentException {
        String dni = "par";

        List<User> userlist = mock(List.class);
        Mockito.when(service.getUsersByDni(dni)).thenThrow(new DniNotExistsException());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DniNotExistsException());
        ResponseEntity result = controller.getUsersByDni(dni);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getUsersByDniNoContentException() throws DniNotExistsException, NoContentException {
        String dni = "par";

        List<User> userlist = mock(List.class);
        Mockito.when(service.getUsersByDni(dni)).thenThrow(new NoContentException("hola"));

        ResponseEntity expected = ResponseEntity.status(HttpStatus.NO_CONTENT).body(new NoContentException("hola"));
        ResponseEntity result = controller.getUsersByDni(dni);
        assertNotNull(result);
        assertEquals(expected,result);
    }

}