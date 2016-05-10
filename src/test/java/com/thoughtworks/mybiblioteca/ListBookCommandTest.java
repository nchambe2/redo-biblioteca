package com.thoughtworks.mybiblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ListBookCommandTest {

    private Command listBookCommand;
    private Library library;

    @Before
    public void setUp() {
        library = mock(Library.class);
        listBookCommand = new ListBookCommand(library);

    }

    @Test
    public void shouldListBooksWhenUserInvokesCommand() {
        listBookCommand.run();

        verify(library).listBooks();

    }


    @Test
    public void shouldReturnListBooksWhenApplicationStarts() {
        assertThat(listBookCommand.name(), is("List Books"));
    }
}