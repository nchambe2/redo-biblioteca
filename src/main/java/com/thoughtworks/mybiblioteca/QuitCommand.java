package com.thoughtworks.mybiblioteca;

public class QuitCommand implements Command {

    private Application application;

    public QuitCommand(Application application) {

        this.application = application;
    }

    @Override
    public void run() {
        application.stop();
    }

    @Override
    public String name() {
        return "Quit";
    }
}