package com.revature;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;

import com.revature.Commands.CommandWords; 

/**
 * Unit test for simple App.
 */
public class CommandWordsTest extends TestCase {

    @Test
    public void testCheckValidCommands() {
        CommandWords commandWords = new CommandWords();
        assertTrue(commandWords.isCommand("north"));
        assertTrue(commandWords.isCommand("east"));
        assertTrue(commandWords.isCommand("south"));
        assertTrue(commandWords.isCommand("west"));
        assertTrue(commandWords.isCommand("quit"));
        assertTrue(commandWords.isCommand("cry"));
        assertTrue(commandWords.isCommand("stop"));
    }

    public void testCheckInalidCommand() {
        CommandWords commandWords = new CommandWords();
        assertFalse(commandWords.isCommand("win"));
    }
}