package com.thoughtworks.mybiblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ApplicationTest {

    private Application application;
    private PrintStream printStream;
    private Boolean applicationStatus;
    private MenuManager menuManager;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        menuManager = mock(MenuManager.class);
        applicationStatus = true;
        application = new Application(printStream, menuManager, applicationStatus);

    }

    @Test
    public void shouldWelcomeUserWhenApplicationStarts() {

        application.start();

        verify(menuManager).manage();

    }

//    @Test
//    public void shouldPrintMenuWhenApplicationStarts() {
//        when(menuPrompter.getUserInput()).thenReturn("0");
//
//        application.start();
//
//        verify(menuValidator).validate("0");
//    }


}