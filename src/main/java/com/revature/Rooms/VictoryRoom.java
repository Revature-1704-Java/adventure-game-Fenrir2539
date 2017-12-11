package com.revature.Rooms;

import java.util.HashMap;

public class VictoryRoom extends Room {

    public boolean isLocked;
	
	public VictoryRoom () {}
	
	public VictoryRoom(String desc) {
		this.desc = desc;
		this.isLocked = true;
		exits = new HashMap<String, Room>();
    }

    public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	public boolean getIsLocked() {
		return isLocked;
    }

}