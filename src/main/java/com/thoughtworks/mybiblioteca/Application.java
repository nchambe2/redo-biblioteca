package com.thoughtworks.mybiblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Application {
    private PrintStream printStream;
    private Menu menu;
    private Map<String, Command> libraryCommand;
    private BufferedReader bufferedReader;

    public Application(PrintStream printStream, Menu menu, Map<String, Command> libraryCommands, BufferedReader bufferedReader) {

        this.printStream = printStream;
        this.menu = menu;
        this.libraryCommand = libraryCommands;
        this.bufferedReader = bufferedReader;
    }

    public void start() {

        do {
            printStream.println("Welcome to Biblioteca");
            menu.print();
            menu.executeUserCommand();
        } while(!libraryCommand.containsKey(promptUserForInput() == "0"));
    }

    private String promptUserForInput() {
        try {
            return bufferedReader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}