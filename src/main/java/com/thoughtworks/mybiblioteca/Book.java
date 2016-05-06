package com.thoughtworks.mybiblioteca;

import java.io.PrintStream;

public class Book {

    private String title;
    private String author;
    private String publishDate;
    private PrintStream printStream;
    private Boolean bookAvailability = true;

    public Book(String title, String author, String publishDate, PrintStream printStream) {

        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.printStream = printStream;
    }

    public String details() {
        return String.join(", ", title, author, publishDate);
    }

    public String getTitle(){
        return title;
    }

    public void checkout() {

        if(bookAvailability == true) {
            bookAvailability = false;
            printCheckoutMessage();
        }
    }

    private void printCheckoutMessage() {
        printStream.println("Thank you! Enjoy the book");
    }
}
