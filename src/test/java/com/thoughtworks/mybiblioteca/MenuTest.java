package com.thoughtworks.mybiblioteca;

        import org.junit.Before;
        import org.junit.Test;

        import java.io.PrintStream;
        import java.util.HashMap;
        import java.util.Map;

        import static org.mockito.Mockito.*;

public class MenuTest {

    private Menu menu;
    private PrintStream printStream;
    private  Map<String, Command>  libraryCommands;
    private Command listBookCommand;
    private Command quitCommand;
    private Command checkoutBookCommand;
    private Command returnBookCommand;

    public MenuTest() {
    }

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        libraryCommands = new HashMap<>();
        listBookCommand = mock(Command.class);
        checkoutBookCommand = mock(Command.class);
        quitCommand = mock(Command.class);
        returnBookCommand = mock(Command.class);
        libraryCommands.put("0", quitCommand);
        libraryCommands.put("1", listBookCommand);
        libraryCommands.put("2", checkoutBookCommand);
        libraryCommands.put("3", returnBookCommand);
        menu = new Menu(printStream, libraryCommands);

    }

    @Test
    public void shouldPrintQuitOptionWhenApplicationStarts(){
        menu.print();

        verify(quitCommand).name();

    }

    @Test
    public void shouldPrintListBookOptionWhenApplicationStarts() {
        menu.print();

        verify(listBookCommand).name();

    }

    @Test
    public void shouldPrintCheckoutBookOptionWhenApplicationStarts() {
        menu.print();

        verify(checkoutBookCommand).name();

    }
    
    @Test
    public void shouldPrintReturnBookOptionWhenApplication() {
        menu.print();

        verify(returnBookCommand).name();
    }

}