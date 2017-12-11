package com.revature;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;
import com.revature.Rooms.Room;

/**
 * Unit test for simple App.
 */
public class RoomTest extends TestCase {
    
        @Test
        public void testRoomConstructor() {
            Room r = new Room("description");
            assertEquals("description", r.getDesc());
        }

    }