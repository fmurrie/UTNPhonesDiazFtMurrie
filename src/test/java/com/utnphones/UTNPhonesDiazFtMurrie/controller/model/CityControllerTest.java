package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CityService;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CountryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CityControllerTest
{
    private CityController controller;
    private CityService service;
    @Before
    public void setUp() throws Exception
    {
        service = mock(CityService.class);
        controller = new CityController(service);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAllCities()
    {
        Mockito.when(service.getAll()).thenReturn(new ArrayList<City>());
        List<City> result= controller.getAllCities();
        assertNotNull(result);
    }

    @Test
    public void getCityById()
    {
        Optional<City> expected=Optional.of(mock(City.class));
        Mockito.when(service.getById(expected.get().getIdCity())).thenReturn(expected);
        Optional<City> result=controller.getCityById(expected.get().getIdCity());
        assertNotNull(result);
        assertEquals(expected,result);
    }
}