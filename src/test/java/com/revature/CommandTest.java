package com.revature;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;

import com.revature.Commands.Command;
import com.revature.Parser.Parser;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner; 

/**
 * Unit test for simple App.
 */
public class CommandTest extends TestCase {
    
    @Test
    public void testCommandConstructor() {
        Command command = new Command("test");
        assertEquals(command.getString(), "test");
    }
}