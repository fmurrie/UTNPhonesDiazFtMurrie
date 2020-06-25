package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.exception.NoContentException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Bill;
import com.utnphones.UTNPhonesDiazFtMurrie.service.BillService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class BillControllerTest
{
    private BillController controller;
    @Mock
    private BillService service;

    @Before
    public void setUp() throws Exception
    {
        initMocks(this);
        controller=new BillController(service);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getBillsByUser() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        List<Bill> expected=new ArrayList<Bill>();
        Mockito.when(service.getBillsByUser(id)).thenReturn(expected);
        List<Bill> result=controller.getBillsByUser(id);
        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void getBillsBetweenDates() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=1;
        List<Bill> expected=new ArrayList<Bill>();
        Mockito.when(service.getBillsBetweenDates(id,mock(Date.class),mock(Date.class))).thenReturn(expected);
        List<Bill> result=controller.getBillsBetweenDates(id,mock(Date.class),mock(Date.class));
        assertNotNull(result);
        assertEquals(expected,result);
    }
}