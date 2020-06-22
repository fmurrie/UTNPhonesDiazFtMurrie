package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.RateDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserTypeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.compositekey.RateId;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Rate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class RateServiceTest
{
    private RateService service;
    private RateDao dao;

    @Before
    public void setUp() throws Exception
    {
        dao=mock(RateDao.class);
        service=new RateService(dao);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAll()
    {
        Mockito.when(dao.findAll()).thenReturn(new ArrayList<Rate>());
        List<Rate> result= service.getAll();
        assertNotNull(result);
    }

    @Test
    public void getById()
    {
        RateId rateId=mock(RateId.class);
        Optional<Rate> expected=Optional.of(new Rate(rateId,null,null,null));
        Mockito.when(dao.findById(expected.get().getRateId())).thenReturn(expected);
        Optional<Rate> result=service.getById(rateId);
        assertNotNull(result);
        assertEquals(expected,result);
    }
}