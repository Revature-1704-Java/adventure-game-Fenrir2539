package com.revature.Rooms;


public interface RoomInterface {
	
	public void setDesc(String str);
	public String getDesc();
	
	public void setExits(String direction, Room exitRoom);
	public Room getExits(String direction);

	public void setType(String str);
	public String getType();
    

}