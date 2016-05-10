package com.thoughtworks.mybiblioteca;

import java.io.BufferedReader;
import java.io.IOException;

public class MenuPrompter {


    private BufferedReader bufferedReader;

    public MenuPrompter(BufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }

    public String getUserInput() {
        try {
            return bufferedReader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
