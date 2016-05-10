package com.thoughtworks.mybiblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ReturnBookCommandTest {

    private Command returnBookCommand;
    private Library library;

    @Before
    public void setUp() {
        returnBookCommand = new ReturnBookCommand(library);
        library = mock(Library.class);
    }

    @Test
    public void shouldReturnBookWhenApplicationStarts() {

        assertThat(returnBookCommand.name(), is("Return Book"));
    }

    @Test
    public void shouldReturnBookWhenUserInvokesCommand() {
        returnBookCommand.run();

        verify(library).returnBook();
    }
}