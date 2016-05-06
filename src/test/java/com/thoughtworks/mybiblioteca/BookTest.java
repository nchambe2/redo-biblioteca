package com.thoughtworks.mybiblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookTest {

    private String title;
    private String author;
    private String publishDate;
    private Book book;
    private Boolean bookAvailability;
    private PrintStream printStream;

    @Before
    public void setUp() {
        title = "title";
        author = "author";
        publishDate = "publishDate";
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldReturnBookDetails() {
        bookAvailability = true;
        book = new Book(title, author, publishDate, printStream, bookAvailability);

        assertThat(book.details(), is("title, author, publishDate"));
    }


    @Test
    public void shouldDisplaySuccessfulCheckoutMessageWhenBookIsAvailable() {
        bookAvailability = true;
        book = new Book(title, author, publishDate, printStream, bookAvailability);

        book.checkout();

        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldDisplyUnsuccessfulCheckoutMessageWhenBookIsNotAvailable() {
        bookAvailability = false;
        book = new Book(title, author, publishDate, printStream, bookAvailability);

        book.checkout();

        verify(printStream).println("That book is not available.");
    }
}