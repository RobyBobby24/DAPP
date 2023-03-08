package model;

import services.PersistenceInterface;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class StandardRoomFactory implements RoomFactory {


	/**
	 *
	 */
	public BattleRoom createBattleRoom() {
		BattleRoom room = new BattleRoom();
		return room;
	}

	public TreasureRoom createTreasureRoom() {
		TreasureRoom room = new TreasureRoom();
		return room;
	}

	public BonfireRoom createBonfireRoom() throws IOException {
		BonfireRoom room = new BonfireRoom();
		return room;
	}

	public MerchantRoom createMerchantRoom() {
		MerchantRoom room = new MerchantRoom();
		return room;
	}

}