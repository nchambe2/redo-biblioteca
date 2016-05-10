package com.thoughtworks.mybiblioteca;

import java.io.PrintStream;

public class Book {

    private String title;
    private String author;
    private String publishDate;
    private PrintStream printStream;
    private Boolean bookAvailability;

    public Book(String title, String author, String publishDate, PrintStream printStream, Boolean bookAvailability) {

        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.printStream = printStream;
        this.bookAvailability = bookAvailability;
    }

    public String details() {
        return String.join(", ", title, author, publishDate);
    }

    public String getTitle(){
        return title;
    }

    public Boolean getBookAvailability() {
        return bookAvailability;
    }

    public void checkout() {

        if(bookAvailability) {
            bookAvailability = false;
            printCheckoutMessage();
        } else {
           printUnsuccessfulCheckoutMessage();
        }
    }


    private void printCheckoutMessage() {
        printStream.println("Thank you! Enjoy the book");
    }

    private void printUnsuccessfulCheckoutMessage() {
        printStream.println("That book is not available.");
    }

    public void returnIt() {
        bookAvailability = true;
        printStream.println("Book has successfully been returned");
    }
}
