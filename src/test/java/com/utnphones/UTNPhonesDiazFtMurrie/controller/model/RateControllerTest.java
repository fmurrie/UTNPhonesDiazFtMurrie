package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.compositekey.RateId;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Rate;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CityService;
import com.utnphones.UTNPhonesDiazFtMurrie.service.RateService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class RateControllerTest
{
    private RateController controller;
    private RateService service;


    @Before
    public void setUp() throws Exception
    {
        service = mock(RateService.class);
        controller = new RateController(service);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAllRates()
    {
        Mockito.when(service.getAll()).thenReturn(new ArrayList<Rate>());
        List<Rate> result= controller.getAllRates();
        assertNotNull(result);
    }

    @Test
    public void getRateById() {
        City originCity=mock(City.class);
        City destinyCity=mock(City.class);
        RateId rateId=new RateId(originCity.getIdCity(),destinyCity.getIdCity());
        Optional<Rate> expected=Optional.of(new Rate(rateId,originCity,destinyCity,null));
        Mockito.when(service.getById(expected.get().getRateId())).thenReturn(expected);
        Optional<Rate> result=controller.getRateById(originCity.getIdCity(),destinyCity.getIdCity());
        assertNotNull(result);
        assertEquals(expected,result);
    }
}