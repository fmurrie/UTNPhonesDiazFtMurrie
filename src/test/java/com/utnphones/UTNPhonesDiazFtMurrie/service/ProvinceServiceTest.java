package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.ProvinceDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.ProvinceDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ProvinceServiceTest
{
    private ProvinceService service;
    private ProvinceDao dao;

    @Before
    public void setUp() throws Exception
    {
        dao=mock(ProvinceDao.class);
        service=new ProvinceService(dao);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAll()
    {
        Mockito.when(dao.findAll()).thenReturn(new ArrayList<Province>());
        List<Province> result= service.getAll();
        assertNotNull(result);
    }

    @Test
    public void getById()
    {
        Optional<Province> expected=Optional.of(mock(Province.class));
        Mockito.when(dao.findById(expected.get().getIdProvince())).thenReturn(expected);
        Optional<Province> result=service.getById(expected.get().getIdProvince());
        assertNotNull(result);
        assertEquals(expected,result);
    }
}