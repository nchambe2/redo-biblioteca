package com.thoughtworks.mybiblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ApplicationTest {

    private Application application;
    private PrintStream printStream;
    private Menu menu;
    private Map<String, Command> libraryCommands;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        menu = mock(Menu.class);
        bufferedReader = mock(BufferedReader.class);
        libraryCommands = mock(HashMap.class);
        application = new Application(printStream, menu, libraryCommands, bufferedReader);

    }

    @Test
    public void shouldWelcomeUserWhenApplicationStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("0");
        when(libraryCommands.containsKey(anyString())).thenReturn(true);
        when(libraryCommands.containsKey(anyString())).thenReturn(false);

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