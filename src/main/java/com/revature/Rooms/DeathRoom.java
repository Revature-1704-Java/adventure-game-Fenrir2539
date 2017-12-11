package com.revature.Rooms;

import java.util.HashMap;

public class DeathRoom extends Room {

    private final boolean isDeath = true;;
	
	public DeathRoom () {}
	
	public DeathRoom(String desc) {
        this.desc = desc;
		exits = new HashMap<String, Room>();
    }
}