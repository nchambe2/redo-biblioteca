package com.thoughtworks.mybiblioteca;


public class CheckoutBookCommand implements Command {

    private Library library;

    public CheckoutBookCommand(Library library) {
       this.library = library;
    }

    @Override
    public void run() {
        library.checkoutBook();
    }

    @Override
    public String name() {
        return "Checkout Book";
    }

}