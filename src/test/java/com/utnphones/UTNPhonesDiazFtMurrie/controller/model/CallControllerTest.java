package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.CallAddRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.NoContentException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CallService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class CallControllerTest {

    private CallController callController;
    @Mock
    private CallService callService;


    @Before
    public void setUp() throws Exception
    {
        initMocks(this);
        callController = new CallController(callService);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addCall() throws PhoneLineException
    {
        Call expected = mock(Call.class);
        Mockito.when(callService.addCall(expected)).thenReturn(expected);
        Call result = callController.addCall(expected);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void getCallsByUser() throws UserNotExistException, ValidationException
    {
        Integer id=10;
        List<Call> expected=new ArrayList<Call>();
        Mockito.when(callService.getCallsByUser(id)).thenReturn(expected);
        List<Call> result = callController.getCallsByUser(id);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void getCallsBetweenDates() throws UserNotExistException, ValidationException, NoContentException {
        Integer id=10;
        List<Call> expected=new ArrayList<Call>();
        Mockito.when(callService.getCallsBetweenDates(id,mock(Date.class),mock(Date.class))).thenReturn(expected);
        List<Call> result = callController.getCallsBetweenDates(id,mock(Date.class),mock(Date.class));
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void getCallById() throws ValidationException, UserNotExistException
    {
        Integer id=10;
        Optional<Call> expected=Optional.of(new Call());
        Mockito.when(callService.getCallById(id)).thenReturn(expected);
        Call result = callController.getCallById(id);
        assertNotNull(result);
        assertEquals(expected.get(), result);
    }

    @Test
    public void getLocation()
    {
    }
}