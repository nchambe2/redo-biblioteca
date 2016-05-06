package com.thoughtworks.mybiblioteca;

import com.thoughtworks.mybiblioteca.Application;
import com.thoughtworks.mybiblioteca.ListBookCommand;
import com.thoughtworks.mybiblioteca.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ApplicationTest {

    private Application application;
    private PrintStream printStream;
    private Menu menu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        menu = mock(Menu.class);
        application = new Application(printStream, menu);

    }

    @Test
    public void shouldWelcomeUserWhenApplicationStarts() {

        application.start();

        verify(printStream).println("Welcome to Biblioteca");
    }

    @Test
    public void shouldPrintMenuWhenApplicationStarts() {
        application.start();

        verify(menu).print();
    }

    @Test
    public void shouldExecuteUserCommandWhenUserInputsSelection() throws IOException {

        application.start();

        verify(menu).executeUserCommand();

    }


}