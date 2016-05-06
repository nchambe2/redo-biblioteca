package com.thoughtworks.mybiblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    private String title;
    private String author;
    private String publishDate;
    private Book book;
    private Boolean bookAvailability = true;
    private PrintStream printStream;

    @Before
    public void setUp() {
        title = "title";
        author = "author";
        publishDate = "publishDate";
        printStream = mock(PrintStream.class);
        book = new Book(title, author, publishDate, printStream);
    }

    @Test
    public void shouldReturnBookDetails() {

        assertThat(book.details(), is("title, author, publishDate"));
    }

    @Test
    public void shouldSuccessfullyCheckoutBookWhenBookIsAvailable() {

        book.checkout();
        assertThat(bookAvailability, is(false));
    }

    @Test
    public void shouldDisplaySuccessfulCheckoutMessageWhenBookIsAvailable() {

        book.checkout();
        verify(printStream).println("Thank you! Enjoy the book");
    }
}