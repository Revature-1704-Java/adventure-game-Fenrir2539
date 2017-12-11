package com.revature;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;

import com.revature.FileIO.FileIO;
import com.revature.Parser.Parser;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner; 

/**
 * Unit test for simple App.
 */
public class FileIOTest extends TestCase {
    
    @Test
    public void testCommandConstructor() {
        FileIO fileIo = new FileIO();
        assertEquals(fileIo.filename, "src/main/resources/HighScores.txt");
    }
}