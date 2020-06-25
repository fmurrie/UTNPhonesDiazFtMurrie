package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CityDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CityServiceTest
{
    private CityService service;
    private CityDao dao;

    @Before
    public void setUp() throws Exception
    {
        dao=mock(CityDao.class);
        service=new CityService(dao);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAll()
    {
        Mockito.when(dao.findAll()).thenReturn(new ArrayList<City>());
        List<City> result= service.getAll();
        assertNotNull(result);
    }

    @Test
    public void getById()
    {
        Optional<City> expected=Optional.of(mock(City.class));
        Mockito.when(dao.findById(expected.get().getIdCity())).thenReturn(expected);
        Optional<City> result=service.getById(expected.get().getIdCity());
        assertNotNull(result);
        assertEquals(expected,result);
    }
}