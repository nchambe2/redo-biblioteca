package com.thoughtworks.mybiblioteca;


import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookCommandTest {

    @Test
    public void shouldCheckoutBookWhenUserInvokesCommand() {
        Library library = mock(Library.class);
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(library);
        checkoutBookCommand.run();

        verify(library).checkoutBook();
    }

}