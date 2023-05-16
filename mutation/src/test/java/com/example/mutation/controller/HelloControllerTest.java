package com.example.mutation.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class HelloControllerTest {

    @InjectMocks
    private HelloController helloController;

    @Test
    public void testGreetings(){
        assertNotNull(helloController.getGreetings());
    }

    @Test
    public void testGreetingsResponse(){
        assertEquals("Hello", helloController.getGreetings().getBody());
    }

    @Test
    public void testGreetingsResponseWithoutAssert(){
        helloController.getGreetings();
    }
}
