package com.thoughtworks.mybiblioteca;

public class MenuManager {

    private Menu menu;
    private MenuValidator menuValidator;

    public MenuManager(Menu menu, MenuValidator menuValidator) {

        this.menu = menu;
        this.menuValidator = menuValidator;
    }

    public void manage() {
        menu.print();
        menuValidator.validate();
    }
}
