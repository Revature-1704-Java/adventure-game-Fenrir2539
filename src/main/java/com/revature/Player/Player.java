package com.revature.Player;

import com.revature.Rooms.Room;

public class Player {
    private Room currentRoom;
    private String name;
    private short health;
    private short score;

    public Player() {
        this.health = 100;
        this.score = 0;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHealth(short health) {
        this.health = health;
        System.out.println("Your Health is: "+health);
    }

    public short getHealth() {
        return health;
    }

    public void setScore(short score) {
        this.score = score;
    }

    public short getScore() {
        return score;
    }    
}