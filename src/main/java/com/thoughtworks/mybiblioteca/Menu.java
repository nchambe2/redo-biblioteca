package com.thoughtworks.mybiblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Menu {

    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Map<String, Command> libraryCommands;

    public Menu(BufferedReader bufferedReader, PrintStream printStream, Map<String, Command> libraryCommands) {

        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.libraryCommands = libraryCommands;
    }


    public void print() {

        printStream.println("0. Quit");
        printStream.println("1. List Books");
        printStream.println("2. Checkout Book");

    }

    public void executeUserCommand() {
        String userInput = promptUserForInput();
        Command command;

        while (!libraryCommands.containsKey(userInput)) {
            printStream.println("Select a valid option!");
            userInput = promptUserForInput();
        }


        command = libraryCommands.get(userInput);
        command.run();

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