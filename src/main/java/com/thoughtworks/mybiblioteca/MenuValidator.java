package com.thoughtworks.mybiblioteca;


import java.io.PrintStream;
import java.util.Map;

public class MenuValidator {

    private Map<String, Command> libraryCommands;
    private PrintStream printStream;
    private Menu menu;
    private MenuPrompter menuPrompter;

    public MenuValidator(Map<String, Command> libraryCommands, PrintStream printStream, Menu menu, MenuPrompter menuPrompter){

        this.libraryCommands = libraryCommands;
        this.printStream = printStream;
        this.menu = menu;
        this.menuPrompter = menuPrompter;
    }

    public void validate() {
        String userInput = menuPrompter.getUserInput();

        if(libraryCommands.containsKey(userInput)) {
            menu.executeUserCommand(userInput);
        } else {
            invalidSelectionMessage();
        }

    }

    private void invalidSelectionMessage() {
        printStream.println("Select a valid option");
    }


}
