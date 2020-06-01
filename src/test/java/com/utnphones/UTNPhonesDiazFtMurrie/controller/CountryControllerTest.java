package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CountryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

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
    public void addCountry()
    {
    }

    @Test
    public void getAllCountries()
    {
        Mockito.when(service.getAll()).thenReturn(new ArrayList<Country>());
        ArrayList<Country> result= (ArrayList<Country>) controller.getAllCountries();
        assertNotNull(result);
    }

    @Test
    public void getCountryById()
    {
        Integer id=10;
        Country country=new Country(id,"ARG","Argentina","54",null);
        Optional<Country> expected=Optional.of(country);
        Mockito.when(service.getById(id)).thenReturn(Optional.of(country));
        ResponseEntity<Optional<Country>> result=controller.getCountryById(id);
        assertEquals(expected,result.getBody());
    }
}