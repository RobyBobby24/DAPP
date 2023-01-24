package model;

import services.PersistenceInterface;

import java.util.List;
import java.util.TreeMap;

public class StandardRoomFactory implements RoomFactory {

	/**
	 *
	 */
	public BattleRoom createBattleRoom() {
		BattleRoom room = new BattleRoom();
		TreeMap<String,String> attribute_value = new TreeMap<>();
		attribute_value.put("name","Browser");
		List<Monster> monsters = PersistenceInterface.getInstance().search(attribute_value,Monster.class);
		room.setMonsters(monsters);
		return room;
	}

}