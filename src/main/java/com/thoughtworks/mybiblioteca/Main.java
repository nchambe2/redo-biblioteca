package com.thoughtworks.mybiblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        MenuPrompter menuPrompter = new MenuPrompter(bufferedReader);
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Ender's Game", "Orson Scott Card", "15 January 1985", printStream, true);
        Book book2 = new Book("The Jungle Book", "Rudyard Kipling", "1894", printStream, true);
        bookList.add(book1);
        bookList.add(book2);
        Library library = new Library(bookList, printStream, menuPrompter);
        Map<String, Command> libraryCommands = new HashMap<>();
        libraryCommands.put("1", new ListBookCommand(library));
        libraryCommands.put("2", new CheckoutBookCommand(library));
        libraryCommands.put("3", new ReturnBookCommand(library));
        Menu menu = new Menu(printStream, libraryCommands);
        MenuValidator menuValidator = new MenuValidator(libraryCommands,printStream, menu, menuPrompter);

        MenuManager menuManager = new MenuManager(menu, menuValidator);
        Application application =  new Application(printStream, menuManager, true);
        libraryCommands.put("0", new QuitCommand(application));
        application.start();
    }
}