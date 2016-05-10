package com.thoughtworks.mybiblioteca;

import java.io.PrintStream;
import java.util.Map;
import java.util.Set;

public class Menu {

    private PrintStream printStream;
    private Map<String, Command> libraryCommands;

    public Menu(PrintStream printStream, Map<String, Command> libraryCommands) {

        this.printStream = printStream;
        this.libraryCommands = libraryCommands;
    }


    public void print() {
        Set<String> libraryKeys = libraryCommands.keySet();
        for (String libraryKey : libraryKeys) {
            printStream.println(libraryKey + ". " + libraryCommands.get(libraryKey).name());
        }

    }

    public void executeUserCommand(String userInput) {
        Command command = libraryCommands.get(userInput);
        command.run();
    }

}