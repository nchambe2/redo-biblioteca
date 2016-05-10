package com.thoughtworks.mybiblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuManagerTest {

    private MenuManager menuManager;
    private Menu menu;
    private MenuValidator menuValidator;

    @Before
    public void setUp() {
        menu = mock(Menu.class);
        menuValidator = mock(MenuValidator.class);
        menuManager = new MenuManager(menu, menuValidator);
    }

    @Test
    public void shouldPrintMenuWhenApplicationStarts() {

        menuManager.manage();

        verify(menu).print();
    }

    @Test
    public void shouldValidateMenuWhenApplicationStarts() {

        menuManager.manage();

        verify(menuValidator).validate();
    }
}