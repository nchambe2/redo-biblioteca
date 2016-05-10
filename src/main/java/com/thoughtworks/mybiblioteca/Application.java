package com.thoughtworks.mybiblioteca;

import java.io.PrintStream;

public class Application {
    private PrintStream printStream;
    private MenuManager menuManger;
    private boolean applicationStatus;

    public Application(PrintStream printStream, MenuManager menuManager, Boolean applicationStatus) {
        this.printStream = printStream;
        this.menuManger =  menuManager;
        this.applicationStatus = applicationStatus;
    }

    public void start() {
        printWelcomeMessage();

        //boolean is
        while (applicationStatus) {
            //takeOrder
            menuManger.manage();
        }

        cleanupProcess();
    }

    private void cleanupProcess() {
        System.exit(0);
    }

    public void stop() {
        applicationStatus = false;
    }

    private void printWelcomeMessage() {
        printStream.println("Welcome to Biblioteca");
    }
}
