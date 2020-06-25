package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.CallController;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InfrastructureWebControllerTest {

    private InfrastructureWebController infrastructureWebController;
    private CallController callController;
    private AdviceController adviceController;

    @Before
    public void setUp() throws Exception {
        callController = mock(CallController.class);
        adviceController = mock(AdviceController.class);

        infrastructureWebController = new InfrastructureWebController(callController,adviceController);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addCall() throws PhoneLineException {

    }
}