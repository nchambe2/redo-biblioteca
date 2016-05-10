package com.thoughtworks.mybiblioteca;

public interface Command {
    void run();

    String name();
}