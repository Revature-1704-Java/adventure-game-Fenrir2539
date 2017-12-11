package com.revature.Rooms;

import java.util.HashMap;

public class EventRoom extends Room {

	private boolean isLoseHP;
	
	public EventRoom () {}
	
	public EventRoom(String desc) {
		this.desc = desc;
		this.isLoseHP = true;
		exits = new HashMap<String, Room>();
	}
	
	public void setIsLoseHP(boolean isLoseHP) {
		this.isLoseHP = isLoseHP;
	}
	public boolean getIsLoseHP() {
		return isLoseHP;
    }

}