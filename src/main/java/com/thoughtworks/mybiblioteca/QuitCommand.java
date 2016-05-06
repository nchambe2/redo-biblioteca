package com.thoughtworks.mybiblioteca;

public class QuitCommand implements Command {

    @Override
    public void run() {
        System.exit(0);
    }
}