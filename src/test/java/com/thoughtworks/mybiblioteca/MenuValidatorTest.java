package com.thoughtworks.mybiblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class MenuValidatorTest {

    private MenuValidator menuValidator;
    private Map<String, Command> libraryCommands;
    private PrintStream printStream;
    private Menu menu;
    private Command listBookCommand;
    private MenuPrompter menuPrompter;

    @Before
    public void setUp() {
        libraryCommands = new HashMap<>();
        printStream = mock(PrintStream.class);
        menu = mock(Menu.class);
        listBookCommand = mock(Command.class);
        libraryCommands.put("1", listBookCommand);
        menuPrompter = mock(MenuPrompter.class);
        menuValidator = new MenuValidator(libraryCommands, printStream, menu, menuPrompter);
    }

    @Test
    public void shouldReturnInvalidOptionMessageWhenUserEntersInvalidInput() throws IOException {
        when(menuPrompter.getUserInput()).thenReturn(anyString());

        menuValidator.validate();

        verify(printStream).println("Select a valid option");

    }

    @Test
    public void shouldExecuteMenuOptionWhenUserEntersValidInput() throws IOException {
        when(menuPrompter.getUserInput()).thenReturn("1");

        menuValidator.validate();

        verify(menu).executeUserCommand("1");

    }


}