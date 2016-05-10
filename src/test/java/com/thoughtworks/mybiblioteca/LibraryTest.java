package com.thoughtworks.mybiblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private List<Book> booksList;
    private PrintStream printStream;
    private Library library;
    private Book book1;
    private MenuPrompter menuPrompter;

    @Before
    public void setUp() {
        booksList = new ArrayList<>();
        book1 = mock(Book.class);
        booksList.add(book1);
        printStream = mock(PrintStream.class);
        menuPrompter = mock(MenuPrompter.class);
        library = new Library(booksList, printStream, menuPrompter);
    }

    @Test
    public void shouldListAllBookDetailsWhenBookIsCheckedIn() {
        library.listBooks();
        verify(book1).details();
    }

    @Test
    public void shouldCheckoutBookWhenBookIsCheckedIn() {
        when(menuPrompter.getUserInput()).thenReturn("Book 1");

        library.checkoutBook();

        verify(book1).checkout();
    }


}