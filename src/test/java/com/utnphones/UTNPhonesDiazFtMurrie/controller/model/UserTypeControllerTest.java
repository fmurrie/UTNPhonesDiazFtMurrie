package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import com.utnphones.UTNPhonesDiazFtMurrie.service.UserTypeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class UserTypeControllerTest
{
    private UserTypeController controller;
    private UserTypeService service;

    @Before
    public void setUp() throws Exception
    {
        service = mock(UserTypeService.class);
        controller = new UserTypeController(service);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAllUserTypes()
    {
        Mockito.when(service.getAll()).thenReturn(new ArrayList<UserType>());
        List<UserType> result= controller.getAllUserTypes();
        assertNotNull(result);
    }

    @Test
    public void getUserTypeById()
    {
        Optional<UserType> expected=Optional.of(mock(UserType.class));
        Mockito.when(service.getById(expected.get().getIdUserType())).thenReturn(expected);
        Optional<UserType> result=controller.getUserTypeById(expected.get().getIdUserType());
        assertNotNull(result);
        assertEquals(expected,result);
    }
}