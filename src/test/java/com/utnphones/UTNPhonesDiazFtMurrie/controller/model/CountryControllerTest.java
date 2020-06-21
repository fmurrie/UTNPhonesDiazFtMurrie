package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;


import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CountryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CountryControllerTest
{
    CountryController controller;
    CountryService service;

    @Before
    public void setUp() throws Exception
    {
        service = mock(CountryService.class);
        controller = new CountryController(service);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAllCountries()
    {
        Mockito.when(service.getAll()).thenReturn(new ArrayList<Country>());
        ResponseEntity<List<Country>> result= controller.getAllCountries();
        assertNotNull(result);
        assertEquals(ResponseEntity.status(HttpStatus.NO_CONTENT).build(),result);
    }

    @Test
    public void getCountryById()
    {
        Integer id=10;
        Country country=new Country(id,"ARG","Argentina","54",null);
        Optional<Country> expected=Optional.of(country);
        Mockito.when(service.getById(id)).thenReturn(Optional.of(country));
        ResponseEntity<Optional<Country>> result=controller.getCountryById(id);
        assertNotNull(result);
        assertEquals(expected,result.getBody());
    }
}