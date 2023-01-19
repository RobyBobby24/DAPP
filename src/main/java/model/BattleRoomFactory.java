package model;

import services.PersistenceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class BattleRoomFactory implements RoomFactory {

	/**
	 *
	 */
	public Room createRoom() {
		BattleRoom room=new BattleRoom();
		TreeMap<String,String> attribute_value=new TreeMap<>();
		attribute_value.put("Name","Browser");
		List<Monster> monsters=PersistenceInterface.getInstance().search(attribute_value,Monster.class);
		room.setMonsters(monsters);
		return room;
	}

}