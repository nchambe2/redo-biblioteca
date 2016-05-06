package com.thoughtworks.mybiblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Library {

    private List<Book> bookList;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public Library(List<Book> bookList, PrintStream printStream, BufferedReader bufferedReader) {

        this.bookList = bookList;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void listBooks() {
        String bookListString = "";

        for(Book book : bookList) {
            bookListString += book.details() + "\n";
        }

        printStream.println(bookListString);
    }


    public void checkoutBook() {
        String bookToCheckout = getUserInput();

        for(Book book : bookList) {
            if (bookToCheckout.equals(book.getTitle())) {
                book.checkout();
            }
        }

    }


    private String getUserInput() {
        try {
            return bufferedReader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}