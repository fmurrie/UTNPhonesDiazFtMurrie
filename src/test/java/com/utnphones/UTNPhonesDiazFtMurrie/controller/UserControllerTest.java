package com.utnphones.UTNPhonesDiazFtMurrie.controller;

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
    public void getUsersByDni() {
        String dni = "par";

        User user = new User(1,new UserType(1,"Cliente",null),"42139828","Sergio","Diaz",
                new City(1,"Mardel","0223",
                        new Province(1,"Buenos Aires",new Country(1,"00","Argentina","+54",null),null)),
                "SergioDiaz","12345",null);

        List<User> expected = List.of(user);
        Mockito.when(service.getUsersByDni(dni)).thenReturn(List.of(user));
        ResponseEntity<List<User>> result = controller.getUsersByDni(dni);
        assertNotNull(result);
        assertEquals(expected,result.getBody());
    }

}