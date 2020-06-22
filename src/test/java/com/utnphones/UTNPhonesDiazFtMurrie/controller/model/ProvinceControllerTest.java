package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CityService;
import com.utnphones.UTNPhonesDiazFtMurrie.service.ProvinceService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ProvinceControllerTest
{
    private ProvinceController controller;
    private ProvinceService service;

    @Before
    public void setUp() throws Exception
    {
        service = mock(ProvinceService.class);
        controller = new ProvinceController(service);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAllProvinces()
    {
        Mockito.when(service.getAll()).thenReturn(new ArrayList<Province>());
        List<Province> result= controller.getAllProvinces();
        assertNotNull(result);
    }

    @Test
    public void getProvinceById()
    {
        Optional<Province> expected=Optional.of(mock(Province.class));
        Mockito.when(service.getById(expected.get().getIdProvince())).thenReturn(expected);
        Optional<Province> result=controller.getProvinceById(expected.get().getIdProvince());
        assertNotNull(result);
        assertEquals(expected,result);
    }
}