package com.thoughtworks.mybiblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {

    private List<Book> bookList;
    private PrintStream printStream;
    private MenuPrompter menuPrompter;

    public Library(List<Book> bookList, PrintStream printStream, MenuPrompter menuPrompter) {

        this.bookList = bookList;
        this.printStream = printStream;
        this.menuPrompter = menuPrompter;
    }

    public void listBooks() {
        String bookListString = "";

        for(Book book : bookList) {
            bookListString += book.details() + "\n";
        }

        printStream.println(bookListString);
    }


    public void checkoutBook() {
        String userBookTitle = menuPrompter.getUserInput();

        try {
            Book book = bookFromTitle(userBookTitle);
            book.checkout();
        } catch (BookNotAvailableException e) {
            printStream.println(e.message);
        }
    }

    public void returnBook() {
        String userBookToReturn = menuPrompter.getUserInput();

        try {
            Book book = bookFromTitle(userBookToReturn);
            bookAvailability(book);
            book.returnIt();
        } catch (BookNotAvailableException e) {
            printStream.println(e.message);
        }

    }

    private Book bookFromTitle(String bookTitle) throws BookNotAvailableException {
        for(Book book : bookList) {
            if(book.getTitle().equals(bookTitle)) {
                return book;
            }
        }

        throw new BookNotAvailableException();
    }

    private Boolean bookAvailability(Book book) {
        return book.getBookAvailability();
    }
}
