package com.revature;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;
import com.revature.Rooms.Room;

/**
 * Unit test for simple App.
 */
public class PlayerTest extends TestCase {
    
        @Test
        public void testRoomConstructor() {
            Room r = new Room("description");
            assertEquals("description", r.getDesc());
        }

        /*
        @Test
        public void testPlayerSetHealth() {
            Player p = new Player();
            p.setHealth((short) 1337);
            assertEquals(1337, p.getHealth());
        }

        @Test
        public void testPlayerInitialScore() {
            Player p = new Player();
            assertEquals(0, p.getScore());
        }

        @Test
        public void testPlayerSetScore() {
            Player p = new Player();
            p.setScore((short) 1337);
            assertEquals(1337, p.getScore());
        }

        @Test
        public void testPlayerSetName() {
            Player p = new Player();
            p.setName("alex");
            assertEquals("alex", p.getName());
        }

        @Test
        public void testPlayerSetRoom() {
            Player p = new Player();
            Room r = new Room();
            p.setCurrentRoom(r);
            assertEquals(r, p.getCurrentRoom());
        }
        */
    }