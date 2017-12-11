package com.revature.Rooms;

import java.util.HashMap;
import java.util.Map;

public class Room implements RoomInterface {
	protected String desc;
	protected String type;
	protected Map<String, Room> exits = new HashMap<String, Room>();

	
	public Room () {}
	
	public Room(String desc) {
		this.desc = desc;
		exits = new HashMap<String, Room>();
    }
	
	public void setDesc(String str) {
		desc = str;
	}
	public String getDesc() {
		return desc;
	}
	
	public void setExits(String direction, Room exitRoom) {
		exits.put(direction, exitRoom);
		
	}
	public Room getExits(String direction) {
		return exits.get(direction);
	}

	public void setType(String str) {
		type = str;
	}
	public String getType() {
		return type;
	}


}