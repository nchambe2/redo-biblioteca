package com.thoughtworks.mybiblioteca;

public class ReturnBookCommand implements Command {

    private Library library;

    public ReturnBookCommand(Library library) {

        this.library = library;
    }

    @Override
    public void run() {
        library.returnBook();
    }

    @Override
    public String name() {
        return "Return Book";
    }
}
