package com.plugin.boilerplate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the Application class.
 */
public class ApplicationTest {

    private static final String EXPECTED_MESSAGE = "Hello from the Application class Test";
    private Application application;

    @Before
    public void setUp() throws Exception {
        application = new Application();
    }

    @After
    public void tearDown() throws Exception {
        application = null;
    }

    @Test
    public void testApplicatiomnCreation() throws Exception {
        assertEquals(EXPECTED_MESSAGE, application.getGreeting("Test"));
    }
}