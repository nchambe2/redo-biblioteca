package com.thoughtworks.mybiblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ListBookCommandTest {

    @Test
    public void shouldListBooksWhenUserInvokesCommand() {
        Library library = mock(Library.class);
        ListBookCommand listBookCommand = new ListBookCommand(library);
        listBookCommand.run();

        verify(library).listBooks();

    }
}