package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.LineTypeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserTypeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.LineType;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class UserTypeServiceTest
{
    private UserTypeService service;
    private UserTypeDao dao;

    @Before
    public void setUp() throws Exception
    {
        dao=mock(UserTypeDao.class);
        service=new UserTypeService(dao);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAll()
    {
        Mockito.when(dao.findAll()).thenReturn(new ArrayList<UserType>());
        List<UserType> result= service.getAll();
        assertNotNull(result);
    }

    @Test
    public void getById()
    {
        Optional<UserType> expected=Optional.of(mock(UserType.class));
        Mockito.when(dao.findById(expected.get().getIdUserType())).thenReturn(expected);
        Optional<UserType> result=service.getById(expected.get().getIdUserType());
        assertNotNull(result);
        assertEquals(expected,result);
    }
}