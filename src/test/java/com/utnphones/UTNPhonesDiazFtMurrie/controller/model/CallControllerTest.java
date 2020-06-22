package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.CallAddRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CallService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CallControllerTest {

    private CallController callController;
    private CallService callService;


    @Before
    public void setUp() throws Exception {///Emulo el atributo y lo asigno al constructor de la clase
        callService = mock(CallService.class);
        callController = new CallController(callService);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addCall() throws PhoneLineException {
            Call expected = mock(Call.class);
            Mockito.when(callService.addCall(expected)).thenReturn(expected);
            //Mockito.when(callService.addCall(expected)).thenThrow(mock(PhoneLineException.class));
            Call result = callController.addCall(expected);

            assertEquals(expected, result);

    }

    @Test
    public void getCallsByUser() {
    }

    @Test
    public void getCallsBetweenDates() {
    }

    @Test
    public void getCallById() {
    }

    @Test
    public void getLocation() {
    }
}