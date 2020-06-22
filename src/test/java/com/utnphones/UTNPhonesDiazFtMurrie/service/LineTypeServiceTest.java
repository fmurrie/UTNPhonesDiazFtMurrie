package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CountryDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.LineTypeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.LineType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LineTypeServiceTest
{
    private LineTypeService service;
    private LineTypeDao dao;

    @Before
    public void setUp() throws Exception
    {
        dao=mock(LineTypeDao.class);
        service=new LineTypeService(dao);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAll()
    {
        Mockito.when(dao.findAll()).thenReturn(new ArrayList<LineType>());
        List<LineType> result= service.getAll();
        assertNotNull(result);
    }

    @Test
    public void getLineById()
    {
        Optional<LineType> expected=Optional.of(mock(LineType.class));
        Mockito.when(dao.findById(expected.get().getIdLineType())).thenReturn(expected);
        Optional<LineType> result=service.getLineById(expected.get().getIdLineType());
        assertNotNull(result);
        assertEquals(expected,result);
    }
}