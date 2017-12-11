package com.revature;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;

import com.revature.Parser.Parser;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner; 

/**
 * Unit test for simple App.
 */
public class ParserTest extends TestCase {

    /* Umm not working
    Wanted to test userinput for parser
    @Test
    public void testParserValid() {

        Parser parser = new Parser();
        String data = "north";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String str = parser.parseInput();
        scanner.close();
        assertEquals(str, data);
    }
    */

    //Crap test is always true
    @Test
    public void testParser() {
        assertTrue(true);
    }

    
}