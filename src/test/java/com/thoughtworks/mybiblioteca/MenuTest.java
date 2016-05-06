package com.thoughtworks.mybiblioteca;

        import org.junit.Before;
        import org.junit.Test;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.PrintStream;
        import java.util.HashMap;
        import java.util.Map;

        import static org.mockito.Matchers.contains;
        import static org.mockito.Mockito.*;

public class MenuTest {

    private BufferedReader bufferedReader;
    private Menu menu;
    private PrintStream printStream;
    private  Map<String, Command>  libraryCommands;
    private ListBookCommand listBookCommand;
    private QuitCommand quitCommand;
    private CheckoutBookCommand checkoutBookCommand;

    @Before
    public void setUP() {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        libraryCommands = mock(HashMap.class);
        listBookCommand = mock(ListBookCommand.class);
        quitCommand = mock(QuitCommand.class);
        checkoutBookCommand = mock(CheckoutBookCommand.class);
        menu = new Menu(bufferedReader, printStream, libraryCommands);

    }

    @Test
    public void shouldPrintMenuOptionsWhenApplicationStarts() throws IOException {

        menu.print();

        verify(printStream).println(contains("1. List Books"));
    }

    @Test
    public void shouldListBooksWhenUserSelectsListBookOption() throws IOException {

        when(bufferedReader.readLine()).thenReturn("1");
        when(libraryCommands.containsKey(anyString())).thenReturn(true);
        when(libraryCommands.get(anyString())).thenReturn(listBookCommand);

        menu.executeUserCommand();

        verify(listBookCommand).run();
    }

    @Test
    public void shouldQuitWhenUserSelectsQuitOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");
        when(libraryCommands.containsKey(anyString())).thenReturn(true);
        when(libraryCommands.get(anyString())).thenReturn(quitCommand);

        menu.executeUserCommand();

        verify(quitCommand).run();

    }

    @Test
    public void shouldCheckoutBookWhenUserSelectsCheckoutBookOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        when(libraryCommands.containsKey(anyString())).thenReturn(true);
        when(libraryCommands.get(anyString())).thenReturn(checkoutBookCommand);

        menu.executeUserCommand();

        verify(checkoutBookCommand).run();

    }

    @Test
    public void shouldShowMessageWhenInvalidUserInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("fjdklsjfalk").thenReturn("1");
        when(libraryCommands.containsKey(anyString())).thenReturn(false).thenReturn(true);
        when(libraryCommands.get(anyString())).thenReturn(quitCommand);

        menu.executeUserCommand();

        verify(printStream).println("Select a valid option!");
    }

}