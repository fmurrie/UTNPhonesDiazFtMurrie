package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.LineType;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import com.utnphones.UTNPhonesDiazFtMurrie.service.LineTypeService;
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

public class LineTypeControllerTest
{
    private LineTypeController controller;
    private LineTypeService service;

    @Before
    public void setUp() throws Exception
    {
        service = mock(LineTypeService.class);
        controller = new LineTypeController(service);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAllLineTypes()
    {
        Mockito.when(service.getAll()).thenReturn(new ArrayList<LineType>());
        List<LineType> result= controller.getAllLineTypes();
        assertNotNull(result);
    }

    @Test
    public void getLineTypeById()
    {
        Optional<LineType> expected=Optional.of(mock(LineType.class));
        Mockito.when(service.getLineById(expected.get().getIdLineType())).thenReturn(expected);
        Optional<LineType> result=controller.getLineTypeById(expected.get().getIdLineType());
        assertNotNull(result);
        assertEquals(expected,result);
    }
}