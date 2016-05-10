package com.thoughtworks.mybiblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookCommandTest {


    private Command checkoutBookCommand;
    private Library library;

    @Before
    public void setUp() {
        library = mock(Library.class);
        checkoutBookCommand = new CheckoutBookCommand(library);
    }

    @Test
    public void shouldCheckoutBookWhenUserInvokesCommand() {
        checkoutBookCommand.run();

        verify(library).checkoutBook();
    }

    @Test
    public void shouldReturnCheckoutBookWhenApplicationStarts() {

        assertThat(checkoutBookCommand.name(), is("Checkout Book"));
    }

}