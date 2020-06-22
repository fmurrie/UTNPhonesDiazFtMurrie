package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CountryDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CountryServiceTest
{
    private CountryService service;
    private CountryDao dao;

    @Before
    public void setUp() throws Exception
    {
        dao=mock(CountryDao.class);
        service=new CountryService(dao);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAll()
    {
        Mockito.when(dao.findAll()).thenReturn(new ArrayList<Country>());
        List<Country> result= service.getAll();
        assertNotNull(result);
    }

    @Test
    public void getById()
    {
        Optional<Country> expected=Optional.of(mock(Country.class));
        Mockito.when(dao.findById(expected.get().getIdCountry())).thenReturn(expected);
        Optional<Country> result=service.getById(expected.get().getIdCountry());
        assertNotNull(result);
        assertEquals(expected,result);
    }
}