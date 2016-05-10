package com.thoughtworks.mybiblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitCommandTest {

    private Command quitCommand;
    private Application application;

    @Before
    public void setUp() {
        application = mock(Application.class);
        quitCommand = new QuitCommand(application);
    }

    @Test
    public void shouldReturnQuitWhenApplicationStart() {

        assertThat(quitCommand.name(), is("Quit"));
    }

    @Test
    public void shouldExitProgramWhenUserInvokesCommand() {
        quitCommand.run();

        verify(application).stop();
    }
}
