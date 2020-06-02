package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CityService;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CountryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CityControllerTest
{
    CityController controller;
    CityService service;

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
    public void getLinesByAreaCode221()
    {
        Mockito.when(service.getByAreaCode221()).thenReturn(new ArrayList<PhoneLine>());
        ResponseEntity<List<PhoneLine>> result= controller.getLinesByAreaCode221();
        assertNotNull(result);
        assertEquals(ResponseEntity.status(HttpStatus.NO_CONTENT).build(),result);
    }
}