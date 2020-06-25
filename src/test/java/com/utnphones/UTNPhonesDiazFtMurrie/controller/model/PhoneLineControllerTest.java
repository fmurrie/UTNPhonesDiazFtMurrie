package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.LineAndCallsQuantityDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.*;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.*;
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
    public void addPhoneLine() throws Exception, LineTypeNotExistsException, ValidationException {
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
    public void getPhoneLine() throws ValidationException, PhoneLineException
    {
        Integer id=1;
        Optional<PhoneLine> expected=Optional.of(new PhoneLine(id,mock(LineType.class),"1234",mock(User.class),false,false,null));
        Mockito.when(service.getPhoneLine(id)).thenReturn(expected);
        PhoneLine result=controller.getPhoneLine(id);
        assertNotNull(result);
        assertEquals(expected.get(),result);
    }

    @Test
    public void top10Destinies() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        List<LineAndCallsQuantityDto> expected=new ArrayList<LineAndCallsQuantityDto>();
        Mockito.when(service.top10Destinies(id)).thenReturn(expected);
        List<LineAndCallsQuantityDto> result=controller.top10Destinies(id);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void suspendPhoneLine() throws ValidationException, PhoneLineException
    {
        Integer id=10;
        PhoneLine expected=new PhoneLine(id,mock(LineType.class),"1234",mock(User.class),false,false,null);
        Mockito.when(service.suspendPhoneLine(id)).thenReturn(expected);
        PhoneLine result=controller.suspendPhoneLine(id);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void enablePhoneLine() throws ValidationException, PhoneLineException
    {
        Integer id=10;
        PhoneLine expected=new PhoneLine(id,mock(LineType.class),"1234",mock(User.class),false,false,null);
        Mockito.when(service.enablePhoneLine(id)).thenReturn(expected);
        PhoneLine result=controller.enablePhoneLine(id);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void deletePhoneLine() throws ValidationException, PhoneLineException
    {
        Integer id=10;
        PhoneLine expected=new PhoneLine(id,mock(LineType.class),"1234",mock(User.class),false,false,null);
        Mockito.when(service.deletePhoneLine(id)).thenReturn(expected);
        PhoneLine result=controller.deletePhoneLine(id);
        assertNotNull(result);
        assertEquals(expected,result);
    }
}