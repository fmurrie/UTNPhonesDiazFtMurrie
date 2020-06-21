package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.exception.LineTypeNotExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.service.PhoneLineService;
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

public class PhoneLineControllerTest
{
    PhoneLineController controller;
    PhoneLineService service;

    @Before
    public void setUp() throws Exception
    {
        service = mock(PhoneLineService.class);
        controller = new PhoneLineController(service);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void addPhoneLine() throws Exception, LineTypeNotExistsException
    {
        PhoneLine phoneLine=mock(PhoneLine.class);
        Mockito.when(service.addPhoneLine(phoneLine)).thenReturn(phoneLine);
        PhoneLine result= controller.addPhoneLine(phoneLine);
        assertNotNull(result);
        assertEquals(phoneLine,result);
    }

    @Test
    public void getAllPhoneLines() throws PhoneLineException
    {
        Mockito.when(service.getAll()).thenReturn(new ArrayList<PhoneLine>());
        List<PhoneLine> result= controller.getAllPhoneLines();
        assertNotNull(result);
    }

    @Test
    public void getPhoneLine()
    {
    }

    @Test
    public void top10Destinataries()
    {
    }

    @Test
    public void getLocation()
    {
    }

    @Test
    public void suspendPhoneLine()
    {
    }

    @Test
    public void enablePhoneLine()
    {
    }

    @Test
    public void deletePhoneLine()
    {
    }
}