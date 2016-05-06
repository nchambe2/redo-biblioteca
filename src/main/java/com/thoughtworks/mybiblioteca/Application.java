package com.thoughtworks.mybiblioteca;

import java.io.PrintStream;

public class Application {
    private PrintStream printStream;
    private Menu menu;

    public Application(PrintStream printStream, Menu menu) {

        this.printStream = printStream;
        this.menu = menu;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca");
        menu.print();
        menu.executeUserCommand();
    }
}